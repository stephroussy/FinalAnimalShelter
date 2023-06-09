package com.animal.shelter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.animal.shelter.entity.DogStaff;

@Component

public class DefaultDogStaffDao implements DogStaffDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // Get method to read the list of DogStaff from DogStaff database

  public List<DogStaff> fetchAllDogStaff() {

    //@formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM dog_staff;";
      //@formatter:on

    // Map<String, Object> params = new HashMap<>(); May not need this
    return jdbcTemplate.query(sql, new RowMapper<DogStaff>() {

      @Override
      public DogStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
          return DogStaff.builder()
              .dogId(rs.getInt("dog_id"))
              .staffId(rs.getInt("staff_id"))
              .build();
          //@formatter:on
      }
    });
  }

  public class DogStaffResultSetExtractor implements ResultSetExtractor<DogStaff> {
    @Override
    public DogStaff extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
        return DogStaff.builder()
            .dogId(rs.getInt("dog_id"))
            .staffId(rs.getInt("staff_id"))
            .build();
        // @formatter:on
    }
  }

  // Put method to update Client within DogStaff table

  @Override
  public DogStaff updateDogStaff(int dogId, int staffId) {
   //@formatter:off
      String sql = ""
          + "UPDATE dog_staff "
          + "SET " 
          + "dog_id = :dog_id, "
          + "staff_id = :staff_id;";
      //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("dog_id", dogId);
    params.put("staff_id", staffId);

    jdbcTemplate.update(sql, params);
    return DogStaff.builder().dogId(dogId).staffId(staffId).build();
  }

  // Get method to read dogs with specified staff id

  public List<DogStaff> fetchDogsByStaffId(int staffId) {
  // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM dog_staff "
        + "WHERE staff_id = :staff_id;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("staff_id", staffId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public DogStaff mapRow(ResultSet rs, int rowNum) throws SQLException {
      // @formatter:off
            return DogStaff.builder()
                .dogId(rs.getInt("dog_id"))
                .staffId(rs.getInt("staff_id"))
                .build();
         // @formatter:on
      }
    });
  }
}
