package examples.springjdbc.dao;

import static examples.springjdbc.dao.MemberDaoSqls.*;

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

import examples.springjdbc.dto.Member;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);

    public MemberDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public List<Member> selectAll() {
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }


    public int insert(Member member) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        return insertAction.executeAndReturnKey(params).intValue();
    }

    public Member selectById(Integer id) {
        try {
            Map<String, ?> params = Collections.singletonMap("id", id);
            return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    

    public int update(Member role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update(UPDATE, params);
    }

    public int deleteById(Integer id) {
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(DELETE_BY_ID, params);
    }
}

