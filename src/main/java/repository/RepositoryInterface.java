package repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergiy on 06.06.17.
 */
public interface RepositoryInterface {
    <T>void add(T entity) throws SQLException;
    <T>void remuve(T entity) throws SQLException;
    <T>void update(T entity) throws SQLException;
    <T>List<T> getAll();

}
