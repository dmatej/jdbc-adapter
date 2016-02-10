/**
 * (C) 2008, ICZ, a.s.
 * Package: cz.i.cis.dbutils.conn Created: 1.7.2008 Author: dmatej
 */

package org.jdbc.adapter.jdbc42;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.ConnectionWrapper;
import org.jdbc.adapter.iface.ResultSetWrapper;
import org.jdbc.adapter.iface.StatementWrapper;


/**
 * Basic statement wrapper. ResultSets are wrapped with {@link Jdbc42ResultSet}, but you can
 * override {@link #wrap(ResultSet)} and use another wrapper.
 *
 * @author <a href="mailto:david.matejcek@i.cz">David Matejcek</a>
 */
public class Jdbc42Statement implements StatementWrapper {
  private static final Logger LOG = Logger.getLogger(Jdbc42Statement.class.getName());

  private final Statement statement;
  private final ConnectionWrapper parentConnection;


  /**
   * @param statement
   * @param parentConnection
   */
  public Jdbc42Statement(final Statement statement, final ConnectionWrapper parentConnection) {
    this.statement = statement;
    this.parentConnection = parentConnection;
  }


  @Override
  public Connection getConnection() throws SQLException {
    if (isClosed()) {
      throw new SQLException("The statement is already closed.");
    }
    return this.parentConnection;
  }


  /**
   * @return directly the wrapped statement.
   */
  protected final Statement getStatement() {
    return statement;
  }


  /**
   * @return directly the wrapped statement casted as {@link PreparedStatement}
   */
  @SuppressWarnings("PMD.CloseResource")
  protected final PreparedStatement getPreparedStatement() {
    return (PreparedStatement) getStatement();
  }


  /**
   * @return directly the wrapped statement casted as {@link CallableStatement}
   */
  @SuppressWarnings("PMD.CloseResource")
  protected final CallableStatement getCallableStatement() {
    return (CallableStatement) getStatement();
  }


  @Override
  public ResultSetWrapper wrap(final ResultSet resultSet) {
    LOG.entering(getClass().getSimpleName(), "wrap", resultSet);
    if (resultSet == null) {
      return null;
    }
    return new Jdbc42ResultSet(resultSet, this);
  }


  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return iface.isInstance(this) || this.statement.isWrapperFor(iface);
  }


  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    return this.statement.unwrap(iface);
  }


  @Override
  public void addBatch(String sql) throws SQLException {
    this.statement.addBatch(sql);
  }


  @Override
  public void cancel() throws SQLException {
    this.statement.cancel();
  }


  @Override
  public void clearBatch() throws SQLException {
    this.statement.clearBatch();
  }


  @Override
  public void clearWarnings() throws SQLException {
    this.statement.clearWarnings();
  }


  @Override
  public void close() throws SQLException {
    this.statement.close();
  }


  @Override
  public boolean execute(String sql) throws SQLException {
    return this.statement.execute(sql);
  }


  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    return this.statement.execute(sql, autoGeneratedKeys);
  }


  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    return this.statement.execute(sql, columnIndexes);
  }


  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    return this.statement.execute(sql, columnNames);
  }


  @Override
  public int[] executeBatch() throws SQLException {
    return this.statement.executeBatch();
  }


  @Override
  public ResultSetWrapper executeQuery(String sql) throws SQLException {
    return wrap(this.statement.executeQuery(sql));
  }


  @Override
  public int executeUpdate(String sql) throws SQLException {
    return this.statement.executeUpdate(sql);
  }


  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return this.statement.executeUpdate(sql, autoGeneratedKeys);
  }


  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    return this.statement.executeUpdate(sql, columnIndexes);
  }


  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    return this.statement.executeUpdate(sql, columnNames);
  }


  @Override
  public int getFetchDirection() throws SQLException {

    return this.statement.getFetchDirection();
  }


  @Override
  public int getFetchSize() throws SQLException {

    return this.statement.getFetchSize();
  }


  @Override
  public ResultSetWrapper getGeneratedKeys() throws SQLException {

    return wrap(this.statement.getGeneratedKeys());
  }


  @Override
  public int getMaxFieldSize() throws SQLException {

    return this.statement.getMaxFieldSize();
  }


  @Override
  public int getMaxRows() throws SQLException {

    return this.statement.getMaxRows();
  }


  @Override
  public boolean getMoreResults() throws SQLException {// NOPMD

    return this.statement.getMoreResults();
  }


  @Override
  public boolean getMoreResults(int current) throws SQLException {

    return this.statement.getMoreResults(current);
  }


  @Override
  public int getQueryTimeout() throws SQLException {

    return this.statement.getQueryTimeout();
  }


  @Override
  public ResultSet getResultSet() throws SQLException {

    return wrap(this.statement.getResultSet());
  }


  @Override
  public int getResultSetConcurrency() throws SQLException {

    return this.statement.getResultSetConcurrency();
  }


  @Override
  public int getResultSetHoldability() throws SQLException {

    return this.statement.getResultSetHoldability();
  }


  @Override
  public int getResultSetType() throws SQLException {

    return this.statement.getResultSetType();
  }


  @Override
  public int getUpdateCount() throws SQLException {

    return this.statement.getUpdateCount();
  }


  @Override
  public SQLWarning getWarnings() throws SQLException {

    return this.statement.getWarnings();
  }


  @Override
  public void setCursorName(String name) throws SQLException {
    this.statement.setCursorName(name);
  }


  @Override
  public void setEscapeProcessing(boolean enable) throws SQLException {
    this.statement.setEscapeProcessing(enable);
  }


  @Override
  public void setFetchDirection(int direction) throws SQLException {
    this.statement.setFetchDirection(direction);
  }


  @Override
  public void setFetchSize(int rows) throws SQLException {
    this.statement.setFetchSize(rows);
  }


  @Override
  public void setMaxFieldSize(int max) throws SQLException {
    this.statement.setMaxFieldSize(max);
  }


  @Override
  public void setMaxRows(int max) throws SQLException {
    this.statement.setMaxRows(max);
  }


  @Override
  public void setQueryTimeout(int seconds) throws SQLException {
    this.statement.setQueryTimeout(seconds);
  }


  @Override
  public boolean isPoolable() throws SQLException {
    return this.statement.isPoolable();
  }


  @Override
  public void setPoolable(boolean poolable) throws SQLException {
    this.statement.setPoolable(poolable);
  }


  @Override
  public boolean isClosed() throws SQLException {
    return this.statement.isClosed();
  }


  @Override
  public void closeOnCompletion() throws SQLException {
    this.statement.closeOnCompletion();
  }


  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    return this.statement.isCloseOnCompletion();
  }


  @Override
  public void addBatch() throws SQLException {
    getPreparedStatement().addBatch();
  }


  @Override
  public void clearParameters() throws SQLException {
    getPreparedStatement().clearParameters();
  }


  @Override
  public boolean execute() throws SQLException {
    return getPreparedStatement().execute();
  }


  @Override
  public ResultSetWrapper executeQuery() throws SQLException {
    return wrap(getPreparedStatement().executeQuery());
  }


  @Override
  public int executeUpdate() throws SQLException {
    return getPreparedStatement().executeUpdate();
  }


  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    return getPreparedStatement().getMetaData();
  }


  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    return getPreparedStatement().getParameterMetaData();
  }


  @Override
  public void setArray(int index, Array array) throws SQLException {
    getPreparedStatement().setArray(index, array);
  }


  @Override
  public void setAsciiStream(int index, InputStream inputStream, int length) throws SQLException {
    getPreparedStatement().setAsciiStream(index, inputStream, length);
  }


  @Override
  public void setBigDecimal(int index, BigDecimal val) throws SQLException {
    getPreparedStatement().setBigDecimal(index, val);
  }


  @Override
  public void setBinaryStream(int index, InputStream inputStream, int length) throws SQLException {
    getPreparedStatement().setBinaryStream(index, inputStream, length);
  }


  @Override
  public void setBlob(int index, Blob val) throws SQLException {
    getPreparedStatement().setBlob(index, val);
  }


  @Override
  public void setBoolean(int index, boolean val) throws SQLException {
    getPreparedStatement().setBoolean(index, val);
  }


  @Override
  public void setByte(int index, byte val) throws SQLException {
    getPreparedStatement().setByte(index, val);
  }


  @Override
  public void setBytes(int index, byte[] val) throws SQLException {
    getPreparedStatement().setBytes(index, val);
  }


  @Override
  public void setCharacterStream(int index, Reader reader, int length) throws SQLException {
    getPreparedStatement().setCharacterStream(index, reader, length);
  }


  @Override
  public void setClob(int index, Clob val) throws SQLException {
    getPreparedStatement().setClob(index, val);
  }


  @Override
  public void setDate(int index, Date val) throws SQLException {
    getPreparedStatement().setDate(index, val);
  }


  @Override
  public void setDate(int index, Date val, Calendar cal) throws SQLException {
    getPreparedStatement().setDate(index, val, cal);
  }


  @Override
  public void setDouble(int index, double val) throws SQLException {
    getPreparedStatement().setDouble(index, val);
  }


  @Override
  public void setFloat(int index, float val) throws SQLException {
    getPreparedStatement().setFloat(index, val);
  }


  @Override
  public void setInt(int index, int val) throws SQLException {
    getPreparedStatement().setInt(index, val);
  }


  @Override
  public void setLong(int index, long val) throws SQLException {
    getPreparedStatement().setLong(index, val);
  }


  @Override
  public void setNull(int index, int sqlType) throws SQLException {
    getPreparedStatement().setNull(index, sqlType);
  }


  @Override
  public void setNull(int index, int sqlType, String typeName) throws SQLException {
    getPreparedStatement().setNull(index, sqlType, typeName);
  }


  @Override
  public void setObject(int index, Object val) throws SQLException {
    getPreparedStatement().setObject(index, val);
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType) throws SQLException {
    getPreparedStatement().setObject(index, val, targetSqlType);
  }


  @Override
  public void setObject(int index, Object val, int targetSqlType, int scale) throws SQLException {
    getPreparedStatement().setObject(index, val, targetSqlType, scale);
  }


  @Override
  public void setRef(int index, Ref val) throws SQLException {
    getPreparedStatement().setRef(index, val);
  }


  @Override
  public void setShort(int index, short val) throws SQLException {
    getPreparedStatement().setShort(index, val);
  }


  @Override
  public void setString(int index, String val) throws SQLException {
    getPreparedStatement().setString(index, val);
  }


  @Override
  public void setTime(int index, Time val) throws SQLException {
    getPreparedStatement().setTime(index, val);
  }


  @Override
  public void setTime(int index, Time val, Calendar cal) throws SQLException {
    getPreparedStatement().setTime(index, val, cal);
  }


  @Override
  public void setTimestamp(int index, Timestamp val) throws SQLException {
    getPreparedStatement().setTimestamp(index, val);
  }


  @Override
  public void setTimestamp(int index, Timestamp val, Calendar cal) throws SQLException {
    getPreparedStatement().setTimestamp(index, val, cal);
  }


  @Override
  public void setURL(int index, URL val) throws SQLException {
    getPreparedStatement().setURL(index, val);
  }


  @Override
  @SuppressWarnings("deprecation")
  @Deprecated
  public void setUnicodeStream(int index, InputStream inputStream, int length) throws SQLException {
    getPreparedStatement().setUnicodeStream(index, inputStream, length);
  }


  @Override
  public void setAsciiStream(int index, InputStream inputStream) throws SQLException {
    getPreparedStatement().setAsciiStream(index, inputStream);
  }


  @Override
  public void setAsciiStream(int index, InputStream inputStream, long length) throws SQLException {
    getPreparedStatement().setAsciiStream(index, inputStream, length);
  }


  @Override
  public void setBinaryStream(int index, InputStream inputStream) throws SQLException {
    getPreparedStatement().setBinaryStream(index, inputStream);
  }


  @Override
  public void setBinaryStream(int index, InputStream inputStream, long length) throws SQLException {
    getPreparedStatement().setBinaryStream(index, inputStream, length);
  }


  @Override
  public void setBlob(int index, InputStream inputStream) throws SQLException {
    getPreparedStatement().setBlob(index, inputStream);
  }


  @Override
  public void setBlob(int index, InputStream inputStream, long length) throws SQLException {
    getPreparedStatement().setBlob(index, inputStream, length);
  }


  @Override
  public void setCharacterStream(int index, Reader reader) throws SQLException {
    getPreparedStatement().setCharacterStream(index, reader);
  }


  @Override
  public void setCharacterStream(int index, Reader reader, long length) throws SQLException {
    getPreparedStatement().setCharacterStream(index, reader, length);
  }


  @Override
  public void setClob(int index, Reader reader) throws SQLException {
    getPreparedStatement().setClob(index, reader);
  }


  @Override
  public void setClob(int index, Reader reader, long length) throws SQLException {
    getPreparedStatement().setClob(index, reader, length);
  }


  @Override
  public void setNCharacterStream(int index, Reader reader) throws SQLException {
    getPreparedStatement().setNCharacterStream(index, reader);
  }


  @Override
  public void setNCharacterStream(int index, Reader reader, long length) throws SQLException {
    getPreparedStatement().setNCharacterStream(index, reader, length);
  }


  @Override
  public void setNClob(int index, NClob nclob) throws SQLException {
    getPreparedStatement().setNClob(index, nclob);
  }


  @Override
  public void setNClob(int index, Reader reader) throws SQLException {
    getPreparedStatement().setNClob(index, reader);
  }


  @Override
  public void setNClob(int index, Reader reader, long length) throws SQLException {
    getPreparedStatement().setNClob(index, reader, length);
  }


  @Override
  public void setNString(int index, String value) throws SQLException {
    getPreparedStatement().setNString(index, value);
  }


  @Override
  public void setRowId(int index, RowId val) throws SQLException {
    getPreparedStatement().setRowId(index, val);
  }


  @Override
  public void setSQLXML(int index, SQLXML valmlObject) throws SQLException {
    getPreparedStatement().setSQLXML(index, valmlObject);
  }


  @Override
  public Array getArray(int index) throws SQLException {
    return getCallableStatement().getArray(index);
  }


  @Override
  public Array getArray(String parameterName) throws SQLException {
    return getCallableStatement().getArray(parameterName);
  }


  @Override
  public BigDecimal getBigDecimal(int index) throws SQLException {
    return getCallableStatement().getBigDecimal(index);
  }


  @Override
  public BigDecimal getBigDecimal(String parameterName) throws SQLException {
    return getCallableStatement().getBigDecimal(parameterName);
  }


  @SuppressWarnings("deprecation")
  @Deprecated
  @Override
  public BigDecimal getBigDecimal(int index, int scale) throws SQLException {
    return getCallableStatement().getBigDecimal(index, scale);
  }


  @Override
  public Blob getBlob(int index) throws SQLException {
    return getCallableStatement().getBlob(index);
  }


  @Override
  public Blob getBlob(String parameterName) throws SQLException {
    return getCallableStatement().getBlob(parameterName);
  }


  @Override
  public boolean getBoolean(int index) throws SQLException {
    return getCallableStatement().getBoolean(index);
  }


  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    return getCallableStatement().getBoolean(parameterName);
  }


  @Override
  public byte getByte(int index) throws SQLException {
    return getCallableStatement().getByte(index);
  }


  @Override
  public byte getByte(String parameterName) throws SQLException {
    return getCallableStatement().getByte(parameterName);
  }


  @Override
  public byte[] getBytes(int index) throws SQLException {
    return getCallableStatement().getBytes(index);
  }


  @Override
  public byte[] getBytes(String parameterName) throws SQLException {
    return getCallableStatement().getBytes(parameterName);
  }


  @Override
  public Clob getClob(int index) throws SQLException {
    return getCallableStatement().getClob(index);
  }


  @Override
  public Clob getClob(String parameterName) throws SQLException {
    return getCallableStatement().getClob(parameterName);
  }


  @Override
  public Date getDate(int index) throws SQLException {
    return getCallableStatement().getDate(index);
  }


  @Override
  public Date getDate(String parameterName) throws SQLException {
    return getCallableStatement().getDate(parameterName);
  }


  @Override
  public Date getDate(int index, Calendar cal) throws SQLException {
    return getCallableStatement().getDate(index, cal);
  }


  @Override
  public Date getDate(String parameterName, Calendar cal) throws SQLException {
    return getCallableStatement().getDate(parameterName, cal);
  }


  @Override
  public double getDouble(int index) throws SQLException {
    return getCallableStatement().getDouble(index);
  }


  @Override
  public double getDouble(String parameterName) throws SQLException {
    return getCallableStatement().getDouble(parameterName);
  }


  @Override
  public float getFloat(int index) throws SQLException {
    return getCallableStatement().getFloat(index);
  }


  @Override
  public float getFloat(String parameterName) throws SQLException {
    return getCallableStatement().getFloat(parameterName);
  }


  @Override
  public int getInt(int index) throws SQLException {
    return getCallableStatement().getInt(index);
  }


  @Override
  public int getInt(String parameterName) throws SQLException {
    return getCallableStatement().getInt(parameterName);
  }


  @Override
  public long getLong(int index) throws SQLException {
    return getCallableStatement().getLong(index);
  }


  @Override
  public long getLong(String parameterName) throws SQLException {
    return getCallableStatement().getLong(parameterName);
  }


  @Override
  public Object getObject(int index) throws SQLException {
    return getCallableStatement().getObject(index);
  }


  @Override
  public Object getObject(String parameterName) throws SQLException {
    return getCallableStatement().getObject(parameterName);
  }


  @Override
  public Object getObject(int index, Map<String, Class<?>> map) throws SQLException {
    return getCallableStatement().getObject(index, map);
  }


  @Override
  public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException {
    return getCallableStatement().getObject(parameterName, map);
  }


  @Override
  public Ref getRef(int index) throws SQLException {
    return getCallableStatement().getRef(index);
  }


  @Override
  public Ref getRef(String parameterName) throws SQLException {
    return getCallableStatement().getRef(parameterName);
  }


  @Override
  public short getShort(int index) throws SQLException {
    return getCallableStatement().getShort(index);
  }


  @Override
  public short getShort(String parameterName) throws SQLException {
    return getCallableStatement().getShort(parameterName);
  }


  @Override
  public String getString(int index) throws SQLException {
    return getCallableStatement().getString(index);
  }


  @Override
  public String getString(String parameterName) throws SQLException {
    return getCallableStatement().getString(parameterName);
  }


  @Override
  public Time getTime(int index) throws SQLException {
    return getCallableStatement().getTime(index);
  }


  @Override
  public Time getTime(String parameterName) throws SQLException {
    return getCallableStatement().getTime(parameterName);
  }


  @Override
  public Time getTime(int index, Calendar cal) throws SQLException {
    return getCallableStatement().getTime(index, cal);
  }


  @Override
  public Time getTime(String parameterName, Calendar cal) throws SQLException {
    return getCallableStatement().getTime(parameterName, cal);
  }


  @Override
  public Timestamp getTimestamp(int index) throws SQLException {
    return getCallableStatement().getTimestamp(index);
  }


  @Override
  public Timestamp getTimestamp(String parameterName) throws SQLException {
    return getCallableStatement().getTimestamp(parameterName);
  }


  @Override
  public Timestamp getTimestamp(int index, Calendar cal) throws SQLException {
    return getCallableStatement().getTimestamp(index, cal);
  }


  @Override
  public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
    return getCallableStatement().getTimestamp(parameterName, cal);
  }


  @Override
  public URL getURL(int index) throws SQLException {
    return getCallableStatement().getURL(index);
  }


  @Override
  public URL getURL(String parameterName) throws SQLException {
    return getCallableStatement().getURL(parameterName);
  }


  @Override
  public void registerOutParameter(int index, int sqlType) throws SQLException {
    getCallableStatement().registerOutParameter(index, sqlType);
  }


  @Override
  public void registerOutParameter(String parameterName, int sqlType) throws SQLException {
    getCallableStatement().registerOutParameter(parameterName, sqlType);
  }


  @Override
  public void registerOutParameter(int index, int sqlType, int scale) throws SQLException {
    getCallableStatement().registerOutParameter(index, sqlType, scale);
  }


  @Override
  public void registerOutParameter(int index, int sqlType, String typeName) throws SQLException {
    getCallableStatement().registerOutParameter(index, sqlType, typeName);
  }


  @Override
  public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException {
    getCallableStatement().registerOutParameter(parameterName, sqlType, scale);
  }


  @Override
  public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException {
    getCallableStatement().registerOutParameter(parameterName, sqlType, typeName);
  }


  @Override
  public void setAsciiStream(String parameterName, InputStream inputStream, int length) throws SQLException {
    getCallableStatement().setAsciiStream(parameterName, inputStream, length);
  }


  @Override
  public void setBigDecimal(String parameterName, BigDecimal val) throws SQLException {
    getCallableStatement().setBigDecimal(parameterName, val);
  }


  @Override
  public void setBinaryStream(String parameterName, InputStream inputStream, int length) throws SQLException {
    getCallableStatement().setBinaryStream(parameterName, inputStream, length);
  }


  @Override
  public void setBoolean(String parameterName, boolean val) throws SQLException {
    getCallableStatement().setBoolean(parameterName, val);
  }


  @Override
  public void setByte(String parameterName, byte val) throws SQLException {
    getCallableStatement().setByte(parameterName, val);
  }


  @Override
  public void setBytes(String parameterName, byte[] val) throws SQLException {
    getCallableStatement().setBytes(parameterName, val);
  }


  @Override
  public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException {
    getCallableStatement().setCharacterStream(parameterName, reader, length);
  }


  @Override
  public void setDate(String parameterName, Date val) throws SQLException {
    getCallableStatement().setDate(parameterName, val);
  }


  @Override
  public void setDate(String parameterName, Date val, Calendar cal) throws SQLException {
    getCallableStatement().setDate(parameterName, val, cal);
  }


  @Override
  public void setDouble(String parameterName, double val) throws SQLException {
    getCallableStatement().setDouble(parameterName, val);
  }


  @Override
  public void setFloat(String parameterName, float val) throws SQLException {
    getCallableStatement().setFloat(parameterName, val);
  }


  @Override
  public void setInt(String parameterName, int val) throws SQLException {
    getCallableStatement().setInt(parameterName, val);
  }


  @Override
  public void setLong(String parameterName, long val) throws SQLException {
    getCallableStatement().setLong(parameterName, val);
  }


  @Override
  public void setNull(String parameterName, int sqlType) throws SQLException {
    getCallableStatement().setNull(parameterName, sqlType);
  }


  @Override
  public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
    getCallableStatement().setNull(parameterName, sqlType, typeName);
  }


  @Override
  public void setObject(String parameterName, Object val) throws SQLException {
    getCallableStatement().setObject(parameterName, val);
  }


  @Override
  public void setObject(String parameterName, Object val, int targetSqlType) throws SQLException {
    getCallableStatement().setObject(parameterName, val, targetSqlType);
  }


  @Override
  public void setObject(String parameterName, Object val, int targetSqlType, int scale) throws SQLException {
    getCallableStatement().setObject(parameterName, val, targetSqlType, scale);
  }


  @Override
  public void setShort(String parameterName, short val) throws SQLException {
    getCallableStatement().setShort(parameterName, val);
  }


  @Override
  public void setString(String parameterName, String val) throws SQLException {
    getCallableStatement().setString(parameterName, val);
  }


  @Override
  public void setTime(String parameterName, Time val) throws SQLException {
    getCallableStatement().setTime(parameterName, val);
  }


  @Override
  public void setTime(String parameterName, Time val, Calendar cal) throws SQLException {
    getCallableStatement().setTime(parameterName, val, cal);
  }


  @Override
  public void setTimestamp(String parameterName, Timestamp val) throws SQLException {
    getCallableStatement().setTimestamp(parameterName, val);
  }


  @Override
  public void setTimestamp(String parameterName, Timestamp val, Calendar cal) throws SQLException {
    getCallableStatement().setTimestamp(parameterName, val, cal);
  }


  @Override
  public void setURL(String parameterName, URL val) throws SQLException {
    getCallableStatement().setURL(parameterName, val);
  }


  @Override
  public boolean wasNull() throws SQLException {
    return getCallableStatement().wasNull();
  }


  @Override
  public Reader getCharacterStream(int index) throws SQLException {
    return getCallableStatement().getCharacterStream(index);
  }


  @Override
  public Reader getCharacterStream(String parameterName) throws SQLException {
    return getCallableStatement().getCharacterStream(parameterName);
  }


  @Override
  public Reader getNCharacterStream(int index) throws SQLException {
    return getCallableStatement().getNCharacterStream(index);
  }


  @Override
  public Reader getNCharacterStream(String parameterName) throws SQLException {
    return getCallableStatement().getNCharacterStream(parameterName);
  }


  @Override
  public NClob getNClob(int index) throws SQLException {
    return getCallableStatement().getNClob(index);
  }


  @Override
  public NClob getNClob(String parameterName) throws SQLException {
    return getCallableStatement().getNClob(parameterName);
  }


  @Override
  public String getNString(int index) throws SQLException {
    return getCallableStatement().getNString(index);
  }


  @Override
  public String getNString(String parameterName) throws SQLException {
    return getCallableStatement().getNString(parameterName);
  }


  @Override
  public RowId getRowId(int index) throws SQLException {
    return getCallableStatement().getRowId(index);
  }


  @Override
  public RowId getRowId(String parameterName) throws SQLException {
    return getCallableStatement().getRowId(parameterName);
  }


  @Override
  public SQLXML getSQLXML(int index) throws SQLException {
    return getCallableStatement().getSQLXML(index);
  }


  @Override
  public SQLXML getSQLXML(String parameterName) throws SQLException {
    return getCallableStatement().getSQLXML(parameterName);
  }


  @Override
  public void setAsciiStream(String parameterName, InputStream inputStream) throws SQLException {
    getCallableStatement().setAsciiStream(parameterName, inputStream);
  }


  @Override
  public void setAsciiStream(String parameterName, InputStream inputStream, long length) throws SQLException {
    getCallableStatement().setAsciiStream(parameterName, inputStream, length);
  }


  @Override
  public void setBinaryStream(String parameterName, InputStream inputStream) throws SQLException {
    getCallableStatement().setBinaryStream(parameterName, inputStream);
  }


  @Override
  public void setBinaryStream(String parameterName, InputStream inputStream, long length) throws SQLException {
    getCallableStatement().setBinaryStream(parameterName, inputStream, length);
  }


  @Override
  public void setBlob(String parameterName, Blob val) throws SQLException {
    getCallableStatement().setBlob(parameterName, val);
  }


  @Override
  public void setBlob(String parameterName, InputStream inputStream) throws SQLException {
    getCallableStatement().setBlob(parameterName, inputStream);
  }


  @Override
  public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {
    getCallableStatement().setBlob(parameterName, inputStream, length);
  }


  @Override
  public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
    getCallableStatement().setCharacterStream(parameterName, reader);
  }


  @Override
  public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
    getCallableStatement().setCharacterStream(parameterName, reader, length);
  }


  @Override
  public void setClob(String parameterName, Clob val) throws SQLException {
    getCallableStatement().setClob(parameterName, val);
  }


  @Override
  public void setClob(String parameterName, Reader reader) throws SQLException {
    getCallableStatement().setClob(parameterName, reader);
  }


  @Override
  public void setClob(String parameterName, Reader reader, long length) throws SQLException {
    getCallableStatement().setClob(parameterName, reader, length);
  }


  @Override
  public void setNCharacterStream(String parameterName, Reader reader) throws SQLException {
    getCallableStatement().setNCharacterStream(parameterName, reader);
  }


  @Override
  public void setNCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
    getCallableStatement().setNCharacterStream(parameterName, reader, length);
  }


  @Override
  public void setNClob(String parameterName, NClob value) throws SQLException {
    getCallableStatement().setNClob(parameterName, value);
  }


  @Override
  public void setNClob(String parameterName, Reader reader) throws SQLException {
    getCallableStatement().setNClob(parameterName, reader);
  }


  @Override
  public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
    getCallableStatement().setNClob(parameterName, reader, length);
  }


  @Override
  public void setNString(String parameterName, String value) throws SQLException {
    getCallableStatement().setNString(parameterName, value);
  }


  @Override
  public void setRowId(String parameterName, RowId val) throws SQLException {
    getCallableStatement().setRowId(parameterName, val);
  }


  @Override
  public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
    getCallableStatement().setSQLXML(parameterName, xmlObject);
  }


  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    return getCallableStatement().getObject(parameterIndex, type);
  }


  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    return getCallableStatement().getObject(parameterName, type);
  }


  @Override
  public int hashCode() {
    return this.statement.hashCode();
  }
}