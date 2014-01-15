package adrese.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import adrese.dao.*;

public class JdbcAdreseDAO extends SimpleJdbcDaoSupport implements AdreseDAO {
  
  public List<Adrese> getAdrese() {
    List<Adrese> list = getSimpleJdbcTemplate().query(
      "select id, nume, email from adrese", new AdreseMapper());
    return list;
  }
  
  public List<Adrese> getAdreseByName(String nume){
    List<Adrese> list = getSimpleJdbcTemplate().query(
      "select id, nume, email from adrese where nume=\'"+nume+"\'",
      new AdreseMapper());
    return list;
  } 
  
  public List<Adrese> getAdreseByEmail(String email){
    List<Adrese> list = getSimpleJdbcTemplate().query(
      "select id, nume, email from adrese where email=\'"+email+"\'",
      new AdreseMapper());
    return list;
  } 
  
  public Adrese getAdreseById(int inregId){
    List<Adrese> list = getSimpleJdbcTemplate().query(
      "select id, nume, email from adrese where id="+inregId,
      new AdreseMapper());
    return (Adrese)list.get(0);
  } 
  
  public void updateAdrese(Adrese inreg) {
    int count = getSimpleJdbcTemplate().update(
      "update adrese set nume = :nume, email = :email where id = :id",
      new MapSqlParameterSource().addValue("nume",inreg.getNume())
      .addValue("email",inreg.getEmail()).addValue("id",inreg.getId()));
  }
  
  public void createAdrese(Adrese inreg) {
    int count = getSimpleJdbcTemplate().update(
      "insert into adrese set nume = :nume, email = :email",
      new MapSqlParameterSource().addValue("nume",inreg.getNume()).addValue("email",inreg.getEmail()));
  }
  
  public void deleteAdrese(Adrese inreg){
    int count=getSimpleJdbcTemplate().update("delete from adrese where id= :id",
      new MapSqlParameterSource().addValue("id",inreg.getId()));
  }
  
  private static class AdreseMapper implements ParameterizedRowMapper<Adrese> { 
    public Adrese mapRow(ResultSet rs, int rowNum) throws SQLException {
      Adrese adrese = new Adrese();
      adrese.setId(rs.getInt("id"));
      adrese.setNume(rs.getString("nume"));
      adrese.setEmail(rs.getString("email"));
      return adrese;
    }  
  }
}
