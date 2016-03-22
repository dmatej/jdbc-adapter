package org.jdbc.adapter.ifx;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.ConnectionWrapper;
import org.jdbc.adapter.iface.ResultSetWrapper;
import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42DatabaseMetaData;

/**
 * @author David Matějček
 */
public class Ifx42DatabaseMetaData extends Jdbc42DatabaseMetaData {

  private static final Logger LOG = Logger.getLogger(Ifx42DatabaseMetaData.class.getName());


  /**
   * @param metaData
   * @param connection
   */
  public Ifx42DatabaseMetaData(final DatabaseMetaData metaData, final ConnectionWrapper connection) {
    super(metaData, connection);
  }


  @Override
  public ResultSetWrapper wrap(final ResultSet resultSet) throws SQLException {
    LOG.entering(getClass().getSimpleName(), "wrap", resultSet);
    if (resultSet == null) {
      return null;
    }
    return new Ifx42ResultSet(resultSet, wrap(resultSet.getStatement()));
  }


  @Override
  public StatementWrapper wrap(final Statement statement) throws SQLException {
    LOG.entering(getClass().getSimpleName(), "wrap", statement);
    if (statement == null) {
      return null;
    }
    return new Ifx42Statement(statement, getConnection());
  }
}
