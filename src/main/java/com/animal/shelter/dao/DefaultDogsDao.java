package com.animal.shelter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.animal.shelter.entity.Dogs;
import com.animal.shelter.entity.Gender;
import com.animal.shelter.entity.Size;

@Component

public class DefaultDogsDao implements DogsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // Get method to read a list of ALL the dogs

  public List<Dogs> fetchAllDogs() {

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM dogs;";
    //@formatter:on

    // Map<String, Object> params = new HashMap<>(); May not need this
    return jdbcTemplate.query(sql, new RowMapper<Dogs>() {

      @Override
      public Dogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Dogs.builder()
            .dogId(rs.getInt("dog_id"))
            .dogName(rs.getString("dog_name"))
            .gender(Gender.valueOf(rs.getString("gender")))
            .birthday(rs.getDate("birthday"))
            .breed(rs.getString("breed"))
            .size(Size.valueOf(rs.getString("size")))
            .clientId(rs.getInt("client _id"))
            .build();
        //@formatter:on
      }
    });
  }

  public class DogsResultSetExtractor implements ResultSetExtractor<Dogs> {
    @Override
    public Dogs extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return Dogs.builder()
          .dogId(rs.getInt("dog_id"))
          .dogName(rs.getString("dog_name"))
          .gender(Gender.valueOf(rs.getString("gender")))
          .birthday(rs.getDate("birthday"))
          .breed(rs.getString("breed"))
          .size(Size.valueOf(rs.getString("size")))
          .clientId(rs.getInt("client_id"))
          .build();
      // @formatter:on
    }
  }

  // Get method to read a list of dogs with specified size

  public List<Dogs> fetchDogsBySize(Size size) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM dogs "
        + "WHERE size = :size;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("size", size);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Dogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
            return Dogs.builder()
                .dogId(rs.getInt("dog_id"))
                .dogName(rs.getString("dog_name"))
                .gender(Gender.valueOf(rs.getString("gender")))
                .birthday(rs.getDate("birthday"))
                .breed(rs.getString("breed"))
                .size(Size.valueOf(rs.getString("size")))
                .clientId(rs.getInt("client_id"))
                .build();
         // @formatter:on
      }
    });
  }

  // Get method to read a list of dogs with specified size

  public List<Dogs> fetchDogsByGender(Gender gender) {
    // @formatter:off
    String sql = ""
       + "SELECT * "
       + "FROM dogs "
       + "WHERE gender = :gender;";
   // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("gender", gender);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Dogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
           return Dogs.builder()
               .dogId(rs.getInt("dog_id"))
               .dogName(rs.getString("dog_name"))
               .gender(Gender.valueOf(rs.getString("gender")))
               .birthday(rs.getDate("birthday"))
               .breed(rs.getString("breed"))
               .size(Size.valueOf(rs.getString("size")))
               .clientId(rs.getInt("client_id"))
               .build();
        // @formatter:on
      }
    });
  }

  // Get method to read a list of dogs with specified dog id)

  public List<Dogs> fetchDogsByDogId(int dogId) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM dogs "
        + "WHERE dog_id = :dog_id;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("dog_id", dogId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Dogs mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
            return Dogs.builder()
                .dogId(rs.getInt("dog_id"))
                .dogName(rs.getString("dog_name"))
                .gender(Gender.valueOf(rs.getString("gender")))
                .birthday(rs.getDate("birthday"))
                .breed(rs.getString("breed"))
                .size(Size.valueOf(rs.getString("size")))
                .clientId(rs.getInt("client_id"))
                .build();
         // @formatter:on
      }
    });
  }


  // Post method to create a new dog within the dogs table


  public Dogs createDogs(String dogName, Gender gender, Date birthday, String breed, Size size,
      int clientId) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql =
        "" + "INSERT into dogs " + "(dog_name, gender, birthday, breed, size, client_id)"
            + "VALUES (:dog_name, :gender, :birthday, :breed, :size, :client_id)";
    sqlparams.source.addValue("dog_name", dogName);
    sqlparams.source.addValue("gender", gender);
    sqlparams.source.addValue("birthday", birthday);
    sqlparams.source.addValue("breed", breed);
    sqlparams.source.addValue("size", size);
    sqlparams.source.addValue("client_id", clientId);


    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Dogs.builder().dogId(keyHolder.getKey().intValue()).dogName(dogName).gender(gender)
        .birthday(birthday).breed(breed).size(size).clientId(clientId).build();
  }

  // This is needed in order to fully implement the create function.
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  // Put method to update Dog within Dogs table

  @Override
  public Dogs updateDogs(int dogId, String dogName, Gender gender, Date birthday, String breed,
      Size size, int clientId) {
    //@formatter:off
     String sql = ""
         + "UPDATE dogs "
         + "SET " 
         + "dog_name = :dog_name, "
         + "gender = :gender, "
         + "birthday = :birthday "
         + "breed = :breed "
         + "size = :size "
         + "client_id = :client_id "
         + "WHERE dog_id = :dog_id;";
     //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("dog_name", dogName);
    params.put("gender", gender);
    params.put("birthday", birthday);
    params.put("breed", breed);
    params.put("size", size);
    params.put("client_id", clientId);

    jdbcTemplate.update(sql, params);
    return Dogs.builder().dogId(dogId).dogName(dogName).gender(gender).birthday(birthday)
        .breed(breed).size(size).clientId(clientId).build();
  }
}
