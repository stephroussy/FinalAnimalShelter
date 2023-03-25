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
import com.animal.shelter.entity.Clients;

@Component

public class DefaultClientsDao implements ClientsDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  // Get method to read the list of clients from clients database

  public List<Clients> fetchAllClients() {

    //@formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM clients;";
      //@formatter:on

    // Map<String, Object> params = new HashMap<>(); May not need this
    return jdbcTemplate.query(sql, new RowMapper<Clients>() {

      @Override
      public Clients mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
          return Clients.builder()
              .clientId(rs.getInt("client_id"))
              .clientFirstName(rs.getString("client_first_name"))
              .clientLastName(rs.getString("client_last_name"))
              .address(rs.getString("client_address"))
              .build();
          //@formatter:on
      }
    });
  }

  public class ClientsResultSetExtractor implements ResultSetExtractor<Clients> {
    @Override
    public Clients extractData(ResultSet rs) throws SQLException, DataAccessException {
      rs.next();
      // @formatter:off
        return Clients.builder()
            .clientId(rs.getInt("client_id"))
            .clientFirstName(rs.getString("client_first_name"))
            .clientLastName(rs.getString("client_last_name"))
            .address(rs.getString("client_address"))
            .build();
        // @formatter:on
    }
  }

  // Get method to read clients with specified last name)

  public List<Clients> fetchClientsByLastName(String clientLastName) {
    // @formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM clients "
          + "WHERE client_last_name = :client_last_name;";
      // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("client_last_name", clientLastName);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Clients mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
              return Clients.builder()
                  .clientId(rs.getInt("client_id"))
                  .clientFirstName(rs.getString("client_first_name"))
                  .clientLastName(rs.getString("client_last_name"))
                  .address(rs.getString("client_address"))
                  .build();
           // @formatter:on
      }
    });
  }

  // Get method to read clients with specified client id)

  public List<Clients> fetchClientsByClientId(Integer clientId) {
    // @formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM clients "
          + "WHERE client_id = :client_id;";
      // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("client_id", clientId);

    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Clients mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
              return Clients.builder()
                  .clientId(rs.getInt("client_id"))
                  .clientFirstName(rs.getString("client_first_name"))
                  .clientLastName(rs.getString("client_last_name"))
                  .address(rs.getString("client_address"))
                  .build();
           // @formatter:on
      }
    });
  }

  // Post method to create a new client within the clients table

  public Clients createClients(String clientFirstName, String clientLastName, String address) {
    SqlParams sqlparams = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    sqlparams.sql =
        "" + "INSERT into clients " + "(client_first_name, client_last_name, client_address)"
            + "VALUES (:client_first_name, :client_last_name, :client_address)";
    sqlparams.source.addValue("client_first_name", clientFirstName);
    sqlparams.source.addValue("client_last_name", clientLastName);
    sqlparams.source.addValue("client_address", address);


    jdbcTemplate.update(sqlparams.sql, sqlparams.source, keyHolder);
    return Clients.builder().clientId(keyHolder.getKey().intValue())
        .clientFirstName(clientFirstName).clientLastName(clientLastName).address(address).build();
  }

  // This is needed in order to fully implement the create function.
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  // Put method to update Client within Clients table

  @Override
  public Clients updateClients(Integer clientId, String clientFirstName, String clientLastName,
      String address) {
    //@formatter:off
       String sql = ""
           + "UPDATE clients "
           + "SET " 
           + "client_first_name = :client_first_name, "
           + "client_last_name = :client_last_name, "
           + "client_address = :client_address "
           + "WHERE client_id = :client_id;";
       //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("client_first_name", clientFirstName);
    params.put("client_last_name", clientLastName);
    params.put("client_address", address);
    params.put("client_id", clientId);

    jdbcTemplate.update(sql, params);
    return Clients.builder().clientId(clientId).clientFirstName(clientFirstName)
        .clientLastName(clientLastName).address(address).build();
  }

}
