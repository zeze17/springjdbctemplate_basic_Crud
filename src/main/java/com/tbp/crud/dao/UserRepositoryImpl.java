package com.tbp.crud.dao;

import com.tbp.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO user(id,fnName,lsName,email) values(?,?,?,?)";
    private static final String UPDATE_USER_BY_ID = "UPDATE USER SET fnName=? WHERE id=?";
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String DELETE_USER_BY_ID = "DELETE FROM user WHERE id=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM user";
    private static final String GET_BY_NAME ="SELECT * FROM user WHERE fnName=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFnName(), user.getLsName(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID, user.getFnName(), user.getId());
        return user;
    }

    @Override
    //OJO QUE ES EL ROE MAPER
    public User getById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, (rs, rowNum) -> {

            return new User(rs.getInt("id"), rs.getString("fnName"),
                    rs.getString("lsName"), rs.getString("email"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update(DELETE_USER_BY_ID, id);
        return "User got deleted with id" + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fnName"),
                    rs.getString("lsName"), rs.getString("email"));
        });
    }

    @Override
    public List<User> allUsersByName() {
        return jdbcTemplate.query(GET_BY_NAME, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fnName"),
                    rs.getString("lsName"), rs.getString("email"));
        });
    }

}
