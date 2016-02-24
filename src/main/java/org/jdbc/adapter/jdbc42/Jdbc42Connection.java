package org.jdbc.adapter.jdbc42;

import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.ConnectionWrapper;
import org.jdbc.adapter.iface.StatementWrapper;


/**
 * Basic connection wrapper. Statements are wrapped with {@link Jdbc42Statement}, but you can
 * override {@link #wrap(Statement)} and use another wrapper.
 *
 * @author <a href="mailto:david.matejcek@i.cz">David Matejcek</a>
 */
public class Jdbc42Connection implements ConnectionWrapper {
  private static final Logger LOG = Logger.getLogger(Jdbc42Connection.class.getName());

  private final Connection connection;

  public Jdbc42Connection(final Connection connection) {
    this.connection = connection;
  }


  /**
   * @return the wrapped connection;
   */
  protected Connection getConnection() {
    return this.connection;
  }


  /**
   * @param statement
   * @return a {@link Jdbc42Statement} instance.
   */
  @Override
  public StatementWrapper wrap(final Statement statement) {
    if (statement == null) {
      return null;
    }
    return new Jdbc42Statement(statement, this);
  }


  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return iface.isInstance(this) || iface.isInstance(this.connection) || this.connection.isWrapperFor(iface);
  }


  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    if (iface.isInstance(this.connection)) {
      return iface.cast(this.connection);
    }
    return this.connection.unwrap(iface);
  }


  @Override
  public void clearWarnings() throws SQLException {
    connection.clearWarnings();
  }


  @Override
  public void commit() throws SQLException {
    connection.commit();
  }


  @Override
  public boolean getAutoCommit() throws SQLException {// NOPMD
    return connection.getAutoCommit();
  }


  @Override
  public String getCatalog() throws SQLException {
    return connection.getCatalog();
  }


  @Override
  public int getHoldability() throws SQLException {
    return connection.getHoldability();
  }


  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return connection.getMetaData();
  }


  @Override
  public int getTransactionIsolation() throws SQLException {
    return connection.getTransactionIsolation();
  }


  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    return connection.getTypeMap();
  }


  @Override
  public SQLWarning getWarnings() throws SQLException {
    return connection.getWarnings();
  }


  @Override
  public boolean isClosed() throws SQLException {
    return connection.isClosed();
  }


  @Override
  public boolean isReadOnly() throws SQLException {
    return connection.isReadOnly();
  }


  @Override
  public String nativeSQL(final String sql) throws SQLException {
    return connection.nativeSQL(sql);
  }


  @Override
  public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
    connection.releaseSavepoint(savepoint);
  }


  @Override
  public void rollback() throws SQLException {
    connection.rollback();
  }


  @Override
  public void rollback(final Savepoint savepoint) throws SQLException {
    connection.rollback(savepoint);
  }


  @Override
  public void setAutoCommit(final boolean autoCommit) throws SQLException {
    connection.setAutoCommit(autoCommit);
  }


  @Override
  public void setCatalog(final String catalog) throws SQLException {
    connection.setCatalog(catalog);
  }


  @Override
  public void setHoldability(int holdability) throws SQLException {
    connection.setHoldability(holdability);
  }


  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    connection.setReadOnly(readOnly);
  }


  @Override
  public Savepoint setSavepoint() throws SQLException {
    return connection.setSavepoint();
  }


  @Override
  public Savepoint setSavepoint(String name) throws SQLException {
    return connection.setSavepoint(name);
  }


  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    connection.setTransactionIsolation(level);
  }


  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    this.connection.setTypeMap(map);
  }


  @Override
  public void close() throws SQLException {
    this.connection.close();
  }


  @Override
  public StatementWrapper createStatement() throws SQLException {
    return wrap(this.connection.createStatement());
  }


  @Override
  public StatementWrapper createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return wrap(this.connection.createStatement(resultSetType, resultSetConcurrency));
  }


  @Override
  public StatementWrapper createStatement(final int resultSetType, final int resultSetConcurrency,
      final int resultSetHoldability) throws SQLException {
    return wrap(this.connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
  }


  @Override
  public StatementWrapper prepareCall(final String sql) throws SQLException {
    return wrap(this.connection.prepareCall(sql));
  }


  @Override
  public StatementWrapper prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
    return wrap(this.connection.prepareCall(sql, resultSetType, resultSetConcurrency));
  }


  @Override
  public StatementWrapper prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
    throws SQLException {
    return wrap(this.connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
  }


  @Override
  public StatementWrapper prepareStatement(final String sql) throws SQLException {
    return wrap(this.connection.prepareStatement(sql));
  }


  @Override
  public StatementWrapper prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    return wrap(this.connection.prepareStatement(sql, autoGeneratedKeys));
  }


  @Override
  public StatementWrapper prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    return wrap(this.connection.prepareStatement(sql, columnIndexes));
  }


  @Override
  public StatementWrapper prepareStatement(String sql, String[] columnNames) throws SQLException {
    return wrap(this.connection.prepareStatement(sql, columnNames));
  }


  @Override
  public StatementWrapper prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
    return wrap(this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency));
  }


  @Override
  public StatementWrapper prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return wrap(this.connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
  }


  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    return this.connection.createArrayOf(typeName, elements);
  }


  @Override
  public Blob createBlob() throws SQLException {
    return this.connection.createBlob();
  }


  @Override
  public Clob createClob() throws SQLException {
    return this.connection.createClob();
  }


  @Override
  public NClob createNClob() throws SQLException {
    return this.connection.createNClob();
  }


  @Override
  public SQLXML createSQLXML() throws SQLException {
    return this.connection.createSQLXML();
  }


  @Override
  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return this.connection.createStruct(typeName, attributes);
  }


  @Override
  public Properties getClientInfo() throws SQLException {
    return this.connection.getClientInfo();
  }


  @Override
  public String getClientInfo(String name) throws SQLException {
    return this.connection.getClientInfo(name);
  }


  @Override
  public boolean isValid(int timeout) throws SQLException {
    return this.connection.isValid(timeout);
  }


  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    this.connection.setClientInfo(properties);
  }


  @Override
  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    this.connection.setClientInfo(name, value);
  }


  @Override
  public void setSchema(String schema) throws SQLException {
    this.connection.setSchema(schema);
  }


  @Override
  public String getSchema() throws SQLException {
    return connection.getSchema();
  }


  @Override
  public void abort(Executor executor) throws SQLException {
    this.connection.abort(executor);
  }


  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    this.connection.setNetworkTimeout(executor, milliseconds);
  }


  @Override
  public int getNetworkTimeout() throws SQLException {
    return connection.getNetworkTimeout();
  }


  @Override
  public int hashCode() {
    return connection.hashCode();
  }
}
