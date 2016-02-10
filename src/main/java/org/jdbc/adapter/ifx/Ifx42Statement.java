package org.jdbc.adapter.ifx;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jdbc.adapter.iface.ConnectionWrapper;
import org.jdbc.adapter.iface.ResultSetWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Statement;

/**
 * @author David Matějček
 */
public class Ifx42Statement extends Jdbc42Statement {

  public Ifx42Statement(final Statement statement, final ConnectionWrapper parentConnection) {
    super(statement, parentConnection);
  }


  @Override
  public ResultSetWrapper wrap(final ResultSet resultSet) {
    if (resultSet == null) {
      return null;
    }
    return new Ifx42ResultSet(resultSet, this);
  }


  @Override
  public void setObject(int index, Object val) throws SQLException {
    getPreparedStatement().setObject(index, fixType(val));
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType) throws SQLException {
    getPreparedStatement().setObject(index, fixType(val), targetSqlType);
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType, int scale) throws SQLException {
    getPreparedStatement().setObject(index, fixType(val), targetSqlType, scale);
  }


  private Object fixType(final Object value) {
    if (value instanceof LocalDateTime) {
      return Timestamp.valueOf((LocalDateTime) value);
    } else if (value instanceof LocalDate) {
      return Date.valueOf((LocalDate) value);
    }
    return value;
  }
}
