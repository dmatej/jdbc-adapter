package org.jdbc.adapter.ifx;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.DatabaseMetaDataWrapper;
import org.jdbc.adapter.iface.StatementWrapper;
import org.jdbc.adapter.jdbc42.Jdbc42Connection;

import com.informix.jdbc.IfmxConnection;

/**
 * @author David Matějček
 */
public class Ifx42Connection extends Jdbc42Connection {

  private static final Logger LOG = Logger.getLogger(Ifx42Connection.class.getName());
  private Properties clientInfo;


  /**
   * @param connection instance of {@link IfmxConnection}
   */
  public Ifx42Connection(final Connection connection) {
    super(connection);
  }


  /**
   * @param statement
   * @return a {@link Ifx42Statement} instance.
   */
  @Override
  public StatementWrapper wrap(final Statement statement) {
    if (statement == null) {
      return null;
    }
    return new Ifx42Statement(statement, this);
  }


  /**
   * @return the wrapped {@link IfmxConnection}.
   */
  @Override
  protected final IfmxConnection getConnection() {
    return IfmxConnection.class.cast(getConnection());
  }


  /**
   * This method is not supported by IFXJDBC driver, but wrapper uses local Properties to give some
   * primitive support.
   *
   * @param properties - source properties to be copied into internal copy.
   */
  @Override
  public void setClientInfo(final Properties properties) throws SQLClientInfoException {
    if (properties == null) {
      this.clientInfo = null;
      return;
    }
    this.clientInfo = new Properties();
    this.clientInfo.putAll(properties);
  }


  /**
   * This method is not supported by IFXJDBC driver, but wrapper uses local Properties to give some
   * primitive support.
   */
  @Override
  public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
    if (this.clientInfo == null) {
      this.clientInfo = new Properties();
    }
    this.clientInfo.setProperty(name, value);
  }


  /**
   * @param metaData
   * @return a {@link DatabaseMetaDataWrapper} instance.
   */
  @Override
  public DatabaseMetaDataWrapper wrap(final DatabaseMetaData metaData) {
    LOG.entering(getClass().getSimpleName(), "wrap", metaData);
    if (metaData == null) {
      return null;
    }
    return new Ifx42DatabaseMetaData(metaData, this);
  }


  /**
   * This method is not supported by IFXJDBC driver, but wrapper uses local Properties to give some
   * primitive support.
   *
   * @return the copy of the internal properties. Never null.
   */
  @Override
  public Properties getClientInfo() throws SQLException {
    if (this.clientInfo == null) {
      return new Properties();
    }
    final Properties toReturn = new Properties();
    toReturn.putAll(this.clientInfo);
    return toReturn;
  }


  /**
   * This method is not supported by IFXJDBC driver, but wrapper uses local Properties to give some
   * primitive support.
   */
  @Override
  public String getClientInfo(final String name) throws SQLException {
    return this.clientInfo == null ? null : this.clientInfo.getProperty(name);
  }


  /**
   * IFXJDBC does not support this method. This wrapper ignores it.
   */
  @Override
  public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
    LOG.warning("This driver does not support the setNetworkTimeout(Executor executor, int milliseconds)."
        + " Method call was ignored.");
  }


  /**
   * IFXJDBC does not support this method. This wrapper always returns 0 (no timeout).
   */
  @Override
  public int getNetworkTimeout() throws SQLException {
    return 0;
  }
}
