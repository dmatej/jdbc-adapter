package org.jdbc.adapter.jdbc42;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.sql.DataSource;

/**
 * Data source for connecting to a database.
 *
 * @author <a href="mailto:david.matejcek@i.cz">David Matejcek</a>
 */
public abstract class Jdbc42DataSource<T extends DataSource> implements DataSource, Serializable, Referenceable {

  private static final long serialVersionUID = 7704044050538199463L;
  private static final Logger LOG = Logger.getLogger(Jdbc42DataSource.class.getName());

  protected final T datasource;


  /**
   * Default constructor.
   *
   * @throws InvalidJdbcDriverException
   */
  public Jdbc42DataSource() throws InvalidJdbcDriverException {
    testDriverExistence();
    this.datasource = createDataSource();
  }


  public Jdbc42DataSource(final T dataSource) {
    this.datasource = dataSource;
  }


  protected T createDataSource() throws InvalidJdbcDriverException {
    try {
      @SuppressWarnings("unchecked")
      final Class<T> clazz = (Class<T>) Class.forName(getDataSourceClassName());
      return clazz.newInstance();
    } catch (final Exception e) {
      throw new InvalidJdbcDriverException("Cannot find the jdbc driver class '" + getDriverClassName() + "'", e);
    }
  }


  protected void testDriverExistence() throws InvalidJdbcDriverException {
    try {
      Class.forName(getDriverClassName());
    } catch (ClassNotFoundException e) {
      throw new InvalidJdbcDriverException("Cannot find the jdbc driver class '" + getDriverClassName() + "'", e);
    }
  }


  public abstract String getDriverClassName();


  public abstract String getDataSourceClassName();


  protected Connection wrapConnection(final Connection connection) {
    LOG.fine("Wrapping the connection " + connection + " to " + Jdbc42Connection.class.getName());
    return new Jdbc42Connection(connection);
  }


  /**
   * Uses the logger with instance class name.
   */
  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return Logger.getLogger(getClass().getCanonicalName());
  }


  @Override
  public synchronized Connection getConnection() throws SQLException {
    return wrapConnection(this.datasource.getConnection());
  }


  @Override
  public Connection getConnection(final String username, final String password) throws SQLException {
    return wrapConnection(datasource.getConnection(username, password));
  }


  @Override
  public PrintWriter getLogWriter() throws SQLException {
    return this.datasource.getLogWriter();
  }


  @Override
  public int getLoginTimeout() throws SQLException {
    return this.datasource.getLoginTimeout();
  }


  @Override
  public void setLogWriter(final PrintWriter out) throws SQLException {
    this.datasource.setLogWriter(out);
  }


  @Override
  public void setLoginTimeout(final int seconds) throws SQLException {
    this.datasource.setLoginTimeout(seconds);
  }


  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return iface.isInstance(this) || iface.isInstance(this.datasource) || this.datasource.isWrapperFor(iface);
  }


  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    if (iface.isInstance(this.datasource)) {
      return iface.cast(this.datasource);
    }
    return iface.cast(this.datasource);
  }


  @Override
  public Reference getReference() throws NamingException {
    return new Reference(getClass().getName(), null, null);
  }
}
