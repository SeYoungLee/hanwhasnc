package examples.springjdbc.dao;

public class MemberDaoSqls {
    public static final String SELECT_ALL = "SELECT id, name, email FROM member order by id";
    public static final String SELECT_BY_ID = "SELECT id, name, email FROM member where id = :id";

    public static final String DELETE_BY_ID = "DELETE FROM member WHERE id = :id";
    public static final String UPDATE = "UPDATE member set name = :name, email = :email where id = :id";
}

