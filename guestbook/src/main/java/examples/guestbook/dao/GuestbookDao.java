package examples.guestbook.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import examples.guestbook.dto.Guestbook;
import static examples.guestbook.dao.GuestbookDaoSqls.*;

@Repository
public class GuestbookDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);

    public GuestbookDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("guestbook")
                .usingGeneratedKeyColumns("id");
    }

    public List<Guestbook> selectAll() {
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }


    public Guestbook insert(Guestbook guestbook) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
        int id = insertAction.executeAndReturnKey(params).intValue();
        guestbook.setId(id);
        return guestbook;
    }

    public Guestbook selectById(Integer id) {
        try {
            Map<String, ?> params = Collections.singletonMap("id", id);
            return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    

    public int update(Guestbook guestbook) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
        return jdbc.update(UPDATE, params);
    }

    public int deleteById(Integer id) {
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(DELETE_BY_ID, params);
    }
}

