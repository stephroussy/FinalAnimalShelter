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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.animal.shelter.entity.Staff;

@Component

public class DefaultStaffDao implements StaffDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // Get method to read the list of staff from staff database

  public List<Staff> fetchAllStaff() {

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM staff;";
    //@formatter:on

    // Map<String, Object> params = new HashMap<>(); May not need this
    return jdbcTemplate.query(sql, new RowMapper<Staff>() {

      @Override
      public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Staff.builder()
            .staffId(rs.getInt("staff_id"))
            .staffFirstName(rs.getString("staff_first_name"))
            .staffLastName(rs.getString("staff_last_name"))
            .build();
        //@formatter:on
      }
    });
  }

  public class StaffResultSetExtractor implements ResultSetExtractor<Staff> {
    @Override
    public Staff extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
      return Staff.builder()
          .staffId(rs.getInt("staff_id"))
          .staffFirstName(rs.getString("staff_first_name"))
          .staffLastName(rs.getString("staff_last_name"))
          .build();
      // @formatter:on
    }
  }

  // Get method to read Staff with specified last name)

  public List<Staff> fetchStaffByLastName(String staffLastName) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM staff "
        + "WHERE staff_last_name = :staff_last_name;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("staff_last_name", staffLastName);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
            return Staff.builder()
                .staffId(rs.getInt("staff_id"))
                .staffFirstName(rs.getString("staff_first_name"))
                .staffLastName(rs.getString("staff_last_name"))
                .build();
         // @formatter:on
      }
    });
  }

  // Get method to read Staff with specified staff id)

  public List<Staff> fetchStaffByStaffId(Integer staffId) {
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM staff "
        + "WHERE staff_id = :staff_id;";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("staff_id", staffId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
            return Staff.builder()
                .staffId(rs.getInt("staff_id"))
                .staffFirstName(rs.getString("staff_first_name"))
                .staffLastName(rs.getString("staff_last_name"))
                .build();
         // @formatter:on
      }
    });
  }

  // Post method to create a new staff within the Staff table

  public Staff createStaff(String staffFirstName, String staffLastName) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql = 
        "" + "INSERT into staff " + "(staff_first_name, staff_last_name)"
    + "VALUES (:staff_first_name, :staff_last_name)";
    sqlparams.source.addValue("staff_first_name", staffFirstName);
    sqlparams.source.addValue("staff_last_name", staffLastName);


    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Staff.builder().staffId(keyHolder.getKey().intValue()).staffFirstName(staffFirstName)
        .staffLastName(staffLastName).build();
  }

  // This is needed in order to fully implement the create function.
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  // Put method to update staff within Staff table

  @Override
  public Staff updateStaff(Integer staffId, String staffFirstName, String staffLastName) {
    //@formatter:off
     String sql = ""
         + "UPDATE staff "
         + "SET " 
         + "staff_first_name = :staff_first_name, "
         + "staff_last_name = :staff_last_name "
         + "WHERE staff_id = :staff_id;";
     //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("staff_first_name", staffFirstName);
    params.put("staff_last_name", staffLastName);
    params.put("staff_id", staffId);

    jdbcTemplate.update(sql, params);
    return Staff.builder().staffId(staffId).staffFirstName(staffFirstName)
        .staffLastName(staffLastName).build();
  }

  // Delete method to delete staff member within Staff table
  @Override
  public void deleteStaff(Integer staffId) {
    //@formatter:off
     String sql = ""
         + "DELETE FROM staff "
         + "WHERE staff_id = :staff_id;";
     //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("staff_id", staffId);

    jdbcTemplate.update(sql, params); // returns number of rows affected
    return;
  }
}
