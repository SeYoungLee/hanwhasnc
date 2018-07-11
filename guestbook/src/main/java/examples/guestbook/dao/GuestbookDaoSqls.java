package examples.guestbook.dao;

public class GuestbookDaoSqls {
    public static final String SELECT_ALL = "SELECT id, name, content, regdate FROM guestbook order by id desc";
    public static final String SELECT_BY_ID = "SELECT id, name, content, regdate FROM guestbook where id = :id";

    public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
    public static final String UPDATE = "UPDATE guestbook set name = :name, content = :content where id = :id";
}

