package org.jdbc.adapter.ifx;

import static org.jdbc.adapter.conversion.DefaultTypeConversions.toJdbc30Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    getPreparedStatement().setObject(index, toJdbc30Type(val));
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType) throws SQLException {
    getPreparedStatement().setObject(index, toJdbc30Type(val), targetSqlType);
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType, int scale) throws SQLException {
    getPreparedStatement().setObject(index, toJdbc30Type(val), targetSqlType, scale);
  }
}
