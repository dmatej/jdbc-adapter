/**
 * (C) 2008, ICZ, a.s.
 * Package: cz.i.cis.dbutils.conn Created: 2.7.2008 Author: dmatej
 */
package org.jdbc.adapter.jdbc42;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
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

import org.jdbc.adapter.iface.ResultSetWrapper;
import org.jdbc.adapter.iface.StatementWrapper;



/**
 * Basic result set wrapper.
 *
 * @author <a href="mailto:david.matejcek@i.cz">David Matejcek</a>
 */
public class Jdbc42ResultSet implements ResultSetWrapper {
  private static final Logger LOG = Logger.getLogger(Jdbc42ResultSet.class.getName());

  private final ResultSet resultSet;
  private final StatementWrapper parentStatement;


  /**
   * @param resultSet
   * @param parentStatement
   */
  public Jdbc42ResultSet(final ResultSet resultSet, final StatementWrapper parentStatement) {
    LOG.entering(getClass().getSimpleName(), "Jdbc42ResultSet", new Object[]{resultSet, parentStatement});
    this.resultSet = resultSet;
    this.parentStatement = parentStatement;
  }


  /**
   * @return wrapped resultSet
   */
  protected final ResultSet getResultSet() {
    return this.resultSet;
  }


  @Override
  public Statement getStatement() throws SQLException {
    if (isClosed()) {
      throw new SQLException("The result set is already closed.");
    }
    return this.parentStatement;
  }


  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return iface.isInstance(this) || iface.isInstance(this.resultSet) || this.resultSet.isWrapperFor(iface);
  }


  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    if (iface.isInstance(this.resultSet)) {
      return iface.cast(this.resultSet);
    }
    return this.resultSet.unwrap(iface);
  }


  @Override
  public boolean absolute(int row) throws SQLException {
    return this.resultSet.absolute(row);
  }


  @Override
  public void afterLast() throws SQLException {
    this.resultSet.afterLast();
  }


  @Override
  public void beforeFirst() throws SQLException {
    this.resultSet.beforeFirst();
  }


  @Override
  public void cancelRowUpdates() throws SQLException {
    this.resultSet.cancelRowUpdates();
  }


  @Override
  public void clearWarnings() throws SQLException {
    this.resultSet.clearWarnings();
  }


  @Override
  public void close() throws SQLException {
    this.resultSet.close();
  }


  @Override
  public void deleteRow() throws SQLException {
    this.resultSet.deleteRow();
  }


  @Override
  public int findColumn(String columnName) throws SQLException {
    return this.resultSet.findColumn(columnName);
  }


  @Override
  public boolean first() throws SQLException {
    return this.resultSet.first();
  }


  @Override
  public Array getArray(int i) throws SQLException {
    return this.resultSet.getArray(i);
  }


  @Override
  public Array getArray(String colName) throws SQLException {
    return this.resultSet.getArray(colName);
  }


  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    return this.resultSet.getAsciiStream(columnIndex);
  }


  @Override
  public InputStream getAsciiStream(String columnName) throws SQLException {
    return this.resultSet.getAsciiStream(columnName);
  }


  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    return this.resultSet.getBigDecimal(columnIndex);
  }


  @Override
  public BigDecimal getBigDecimal(String columnName) throws SQLException {
    return this.resultSet.getBigDecimal(columnName);
  }


  @Override
  @SuppressWarnings("deprecation")
  @Deprecated
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    return this.resultSet.getBigDecimal(columnIndex, scale);
  }


  @Override
  @SuppressWarnings("deprecation")
  @Deprecated
  public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
    return this.resultSet.getBigDecimal(columnName, scale);
  }


  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    return this.resultSet.getBinaryStream(columnIndex);
  }


  @Override
  public InputStream getBinaryStream(String columnName) throws SQLException {
    return this.resultSet.getBinaryStream(columnName);
  }


  @Override
  public Blob getBlob(int i) throws SQLException {
    return this.resultSet.getBlob(i);
  }


  @Override
  public Blob getBlob(String colName) throws SQLException {
    return this.resultSet.getBlob(colName);
  }


  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    return this.resultSet.getBoolean(columnIndex);
  }


  @Override
  public boolean getBoolean(String columnName) throws SQLException {
    return this.resultSet.getBoolean(columnName);
  }


  @Override
  public byte getByte(int columnIndex) throws SQLException {
    return this.resultSet.getByte(columnIndex);
  }


  @Override
  public byte getByte(String columnName) throws SQLException {
    return this.resultSet.getByte(columnName);
  }


  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    return this.resultSet.getBytes(columnIndex);
  }


  @Override
  public byte[] getBytes(String columnName) throws SQLException {
    return this.resultSet.getBytes(columnName);
  }


  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    return this.resultSet.getCharacterStream(columnIndex);
  }


  @Override
  public Reader getCharacterStream(String columnName) throws SQLException {
    return this.resultSet.getCharacterStream(columnName);
  }


  @Override
  public Clob getClob(int i) throws SQLException {
    return this.resultSet.getClob(i);
  }


  @Override
  public Clob getClob(String colName) throws SQLException {
    return this.resultSet.getClob(colName);
  }


  @Override
  public int getConcurrency() throws SQLException {
    return this.resultSet.getConcurrency();
  }


  @Override
  public String getCursorName() throws SQLException {
    return this.resultSet.getCursorName();
  }


  @Override
  public Date getDate(int columnIndex) throws SQLException {
    return this.resultSet.getDate(columnIndex);
  }


  @Override
  public Date getDate(String columnName) throws SQLException {
    return this.resultSet.getDate(columnName);
  }


  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    return this.resultSet.getDate(columnIndex, cal);
  }


  @Override
  public Date getDate(String columnName, Calendar cal) throws SQLException {
    return this.resultSet.getDate(columnName, cal);
  }


  @Override
  public double getDouble(int columnIndex) throws SQLException {
    return this.resultSet.getDouble(columnIndex);
  }


  @Override
  public double getDouble(String columnName) throws SQLException {
    return this.resultSet.getDouble(columnName);
  }


  @Override
  public int getFetchDirection() throws SQLException {
    return this.resultSet.getFetchDirection();
  }


  @Override
  public int getFetchSize() throws SQLException {
    return this.resultSet.getFetchSize();
  }


  @Override
  public float getFloat(int columnIndex) throws SQLException {
    return this.resultSet.getFloat(columnIndex);
  }


  @Override
  public float getFloat(String columnName) throws SQLException {
    return this.resultSet.getFloat(columnName);
  }


  @Override
  public int getInt(int columnIndex) throws SQLException {
    return this.resultSet.getInt(columnIndex);
  }


  @Override
  public int getInt(String columnName) throws SQLException {
    return this.resultSet.getInt(columnName);
  }


  @Override
  public long getLong(int columnIndex) throws SQLException {
    return this.resultSet.getLong(columnIndex);
  }


  @Override
  public long getLong(String columnName) throws SQLException {
    return this.resultSet.getLong(columnName);
  }


  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    return this.resultSet.getMetaData();
  }


  @Override
  public Object getObject(int columnIndex) throws SQLException {
    return this.resultSet.getObject(columnIndex);
  }


  @Override
  public Object getObject(String columnName) throws SQLException {
    return this.resultSet.getObject(columnName);
  }


  @Override
  public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
    return this.resultSet.getObject(i, map);
  }


  @Override
  public Object getObject(String colName, Map<String, Class<?>> map) throws SQLException {
    return this.resultSet.getObject(colName, map);
  }


  @Override
  public Ref getRef(int i) throws SQLException {
    return this.resultSet.getRef(i);
  }


  @Override
  public Ref getRef(String colName) throws SQLException {
    return this.resultSet.getRef(colName);
  }


  @Override
  public int getRow() throws SQLException {
    return this.resultSet.getRow();
  }


  @Override
  public short getShort(int columnIndex) throws SQLException {
    return this.resultSet.getShort(columnIndex);
  }


  @Override
  public short getShort(String columnName) throws SQLException {
    return this.resultSet.getShort(columnName);
  }


  @Override
  public String getString(int columnIndex) throws SQLException {
    return this.resultSet.getString(columnIndex);
  }


  @Override
  public String getString(String columnName) throws SQLException {
    return this.resultSet.getString(columnName);
  }


  @Override
  public Time getTime(int columnIndex) throws SQLException {
    return this.resultSet.getTime(columnIndex);
  }


  @Override
  public Time getTime(String columnName) throws SQLException {
    return this.resultSet.getTime(columnName);
  }


  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    return this.resultSet.getTime(columnIndex, cal);
  }


  @Override
  public Time getTime(String columnName, Calendar cal) throws SQLException {
    return this.resultSet.getTime(columnName, cal);
  }


  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    return this.resultSet.getTimestamp(columnIndex);
  }


  @Override
  public Timestamp getTimestamp(String columnName) throws SQLException {
    return this.resultSet.getTimestamp(columnName);
  }


  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    return this.resultSet.getTimestamp(columnIndex, cal);
  }


  @Override
  public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
    return this.resultSet.getTimestamp(columnName, cal);
  }


  @Override
  public int getType() throws SQLException {
    return this.resultSet.getType();
  }


  @Override
  public URL getURL(int columnIndex) throws SQLException {
    return this.resultSet.getURL(columnIndex);
  }


  @Override
  public URL getURL(String columnName) throws SQLException {
    return this.resultSet.getURL(columnName);
  }


  @Override
  @SuppressWarnings("deprecation")
  @Deprecated
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    return this.resultSet.getUnicodeStream(columnIndex);
  }


  @Override
  @SuppressWarnings("deprecation")
  @Deprecated
  public InputStream getUnicodeStream(String columnName) throws SQLException {
    return this.resultSet.getUnicodeStream(columnName);
  }


  @Override
  public SQLWarning getWarnings() throws SQLException {
    return this.resultSet.getWarnings();
  }


  @Override
  public void insertRow() throws SQLException {
    this.resultSet.insertRow();
  }


  @Override
  public boolean isAfterLast() throws SQLException {
    return this.resultSet.isAfterLast();
  }


  @Override
  public boolean isBeforeFirst() throws SQLException {
    return this.resultSet.isBeforeFirst();
  }


  @Override
  public boolean isFirst() throws SQLException {
    return this.resultSet.isFirst();
  }


  @Override
  public boolean isLast() throws SQLException {
    return this.resultSet.isLast();
  }


  @Override
  public boolean last() throws SQLException {
    return this.resultSet.last();
  }


  @Override
  public void moveToCurrentRow() throws SQLException {
    this.resultSet.moveToCurrentRow();
  }


  @Override
  public void moveToInsertRow() throws SQLException {
    this.resultSet.moveToInsertRow();
  }


  @Override
  public boolean next() throws SQLException {
    return this.resultSet.next();
  }


  @Override
  public boolean previous() throws SQLException {
    return this.resultSet.previous();
  }


  @Override
  public void refreshRow() throws SQLException {
    this.resultSet.refreshRow();
  }


  @Override
  public boolean relative(int rows) throws SQLException {
    return this.resultSet.relative(rows);
  }


  @Override
  public boolean rowDeleted() throws SQLException {
    return this.resultSet.rowDeleted();
  }


  @Override
  public boolean rowInserted() throws SQLException {
    return this.resultSet.rowInserted();
  }


  @Override
  public boolean rowUpdated() throws SQLException {
    return this.resultSet.rowUpdated();
  }


  @Override
  public void setFetchDirection(int direction) throws SQLException {
    this.resultSet.setFetchDirection(direction);
  }


  @Override
  public void setFetchSize(int rows) throws SQLException {
    this.resultSet.setFetchSize(rows);
  }


  @Override
  public void updateArray(int columnIndex, Array x) throws SQLException {
    this.resultSet.updateArray(columnIndex, x);
  }


  @Override
  public void updateArray(String columnName, Array x) throws SQLException {
    this.resultSet.updateArray(columnName, x);
  }


  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
    this.resultSet.updateAsciiStream(columnIndex, x, length);
  }


  @Override
  public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
    this.resultSet.updateAsciiStream(columnName, x, length);
  }


  @Override
  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
    this.resultSet.updateBigDecimal(columnIndex, x);
  }


  @Override
  public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
    this.resultSet.updateBigDecimal(columnName, x);
  }


  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
    this.resultSet.updateBinaryStream(columnIndex, x, length);
  }


  @Override
  public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
    this.resultSet.updateBinaryStream(columnName, x, length);
  }


  @Override
  public void updateBlob(int columnIndex, Blob x) throws SQLException {
    this.resultSet.updateBlob(columnIndex, x);
  }


  @Override
  public void updateBlob(String columnName, Blob x) throws SQLException {
    this.resultSet.updateBlob(columnName, x);
  }


  @Override
  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    this.resultSet.updateBoolean(columnIndex, x);
  }


  @Override
  public void updateBoolean(String columnName, boolean x) throws SQLException {
    this.resultSet.updateBoolean(columnName, x);
  }


  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException {
    this.resultSet.updateByte(columnIndex, x);
  }


  @Override
  public void updateByte(String columnName, byte x) throws SQLException {
    this.resultSet.updateByte(columnName, x);
  }


  @Override
  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    this.resultSet.updateBytes(columnIndex, x);
  }


  @Override
  public void updateBytes(String columnName, byte[] x) throws SQLException {
    this.resultSet.updateBytes(columnName, x);
  }


  @Override
  public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
    this.resultSet.updateCharacterStream(columnIndex, x, length);
  }


  @Override
  public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
    this.resultSet.updateCharacterStream(columnName, reader, length);
  }


  @Override
  public void updateClob(int columnIndex, Clob x) throws SQLException {
    this.resultSet.updateClob(columnIndex, x);
  }


  @Override
  public void updateClob(String columnName, Clob x) throws SQLException {
    this.resultSet.updateClob(columnName, x);
  }


  @Override
  public void updateDate(int columnIndex, Date x) throws SQLException {
    this.resultSet.updateDate(columnIndex, x);
  }


  @Override
  public void updateDate(String columnName, Date x) throws SQLException {
    this.resultSet.updateDate(columnName, x);
  }


  @Override
  public void updateDouble(int columnIndex, double x) throws SQLException {
    this.resultSet.updateDouble(columnIndex, x);
  }


  @Override
  public void updateDouble(String columnName, double x) throws SQLException {
    this.resultSet.updateDouble(columnName, x);
  }


  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException {
    this.resultSet.updateFloat(columnIndex, x);
  }


  @Override
  public void updateFloat(String columnName, float x) throws SQLException {
    this.resultSet.updateFloat(columnName, x);
  }


  @Override
  public void updateInt(int columnIndex, int x) throws SQLException {
    this.resultSet.updateInt(columnIndex, x);
  }


  @Override
  public void updateInt(String columnName, int x) throws SQLException {
    this.resultSet.updateInt(columnName, x);
  }


  @Override
  public void updateLong(int columnIndex, long x) throws SQLException {
    this.resultSet.updateLong(columnIndex, x);
  }


  @Override
  public void updateLong(String columnName, long x) throws SQLException {
    this.resultSet.updateLong(columnName, x);
  }


  @Override
  public void updateNull(int columnIndex) throws SQLException {
    this.resultSet.updateNull(columnIndex);
  }


  @Override
  public void updateNull(String columnName) throws SQLException {
    this.resultSet.updateNull(columnName);
  }


  @Override
  public void updateObject(int columnIndex, Object x) throws SQLException {
    this.resultSet.updateObject(columnIndex, x);
  }


  @Override
  public void updateObject(String columnName, Object x) throws SQLException {
    this.resultSet.updateObject(columnName, x);
  }


  @Override
  public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
    this.resultSet.updateObject(columnIndex, x, scale);
  }


  @Override
  public void updateObject(String columnName, Object x, int scale) throws SQLException {
    this.resultSet.updateObject(columnName, x, scale);
  }


  @Override
  public void updateRef(int columnIndex, Ref x) throws SQLException {
    this.resultSet.updateRef(columnIndex, x);
  }


  @Override
  public void updateRef(String columnName, Ref x) throws SQLException {
    this.resultSet.updateRef(columnName, x);
  }


  @Override
  public void updateRow() throws SQLException {
    this.resultSet.updateRow();
  }


  @Override
  public void updateShort(int columnIndex, short x) throws SQLException {
    this.resultSet.updateShort(columnIndex, x);
  }


  @Override
  public void updateShort(String columnName, short x) throws SQLException {
    this.resultSet.updateShort(columnName, x);
  }


  @Override
  public void updateString(int columnIndex, String x) throws SQLException {
    this.resultSet.updateString(columnIndex, x);
  }


  @Override
  public void updateString(String columnName, String x) throws SQLException {
    this.resultSet.updateString(columnName, x);
  }


  @Override
  public void updateTime(int columnIndex, Time x) throws SQLException {
    this.resultSet.updateTime(columnIndex, x);
  }


  @Override
  public void updateTime(String columnName, Time x) throws SQLException {
    this.resultSet.updateTime(columnName, x);
  }


  @Override
  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
    this.resultSet.updateTimestamp(columnIndex, x);
  }


  @Override
  public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
    this.resultSet.updateTimestamp(columnName, x);
  }


  @Override
  public boolean wasNull() throws SQLException {
    return this.resultSet.wasNull();
  }


  @Override
  public int getHoldability() throws SQLException {
    return this.resultSet.getHoldability();
  }


  @Override
  public Reader getNCharacterStream(int columnIndex) throws SQLException {
    return this.resultSet.getNCharacterStream(columnIndex);
  }


  @Override
  public Reader getNCharacterStream(String columnLabel) throws SQLException {
    return this.resultSet.getNCharacterStream(columnLabel);
  }


  @Override
  public NClob getNClob(int columnIndex) throws SQLException {
    return this.resultSet.getNClob(columnIndex);
  }


  @Override
  public NClob getNClob(String columnLabel) throws SQLException {
    return this.resultSet.getNClob(columnLabel);
  }


  @Override
  public String getNString(int columnIndex) throws SQLException {
    return this.resultSet.getNString(columnIndex);
  }


  @Override
  public String getNString(String columnLabel) throws SQLException {
    return this.resultSet.getNString(columnLabel);
  }


  @Override
  public RowId getRowId(int columnIndex) throws SQLException {
    return this.resultSet.getRowId(columnIndex);
  }


  @Override
  public RowId getRowId(String columnLabel) throws SQLException {
    return this.resultSet.getRowId(columnLabel);
  }


  @Override
  public SQLXML getSQLXML(int columnIndex) throws SQLException {
    return this.resultSet.getSQLXML(columnIndex);
  }


  @Override
  public SQLXML getSQLXML(String columnLabel) throws SQLException {
    return this.resultSet.getSQLXML(columnLabel);
  }


  @Override
  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
    return resultSet.getObject(columnIndex, type);
  }


  @Override
  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
    return resultSet.getObject(columnLabel, type);
  }


  @Override
  public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
    this.resultSet.updateAsciiStream(columnIndex, x);
  }


  @Override
  public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
    this.resultSet.updateAsciiStream(columnLabel, x);
  }


  @Override
  public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
    this.resultSet.updateAsciiStream(columnIndex, x, length);
  }


  @Override
  public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
    this.resultSet.updateAsciiStream(columnLabel, x, length);
  }


  @Override
  public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
    this.resultSet.updateBinaryStream(columnIndex, x);
  }


  @Override
  public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
    this.resultSet.updateBinaryStream(columnLabel, x);
  }


  @Override
  public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
    this.resultSet.updateBinaryStream(columnIndex, x, length);
  }


  @Override
  public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
    this.resultSet.updateBinaryStream(columnLabel, x, length);
  }


  @Override
  public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
    this.resultSet.updateBlob(columnIndex, inputStream);
  }


  @Override
  public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
    this.resultSet.updateBlob(columnLabel, inputStream);
  }


  @Override
  public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
    this.resultSet.updateBlob(columnIndex, inputStream, length);
  }


  @Override
  public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
    this.resultSet.updateBlob(columnLabel, inputStream, length);
  }


  @Override
  public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
    this.resultSet.updateCharacterStream(columnIndex, x);
  }


  @Override
  public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
    this.resultSet.updateCharacterStream(columnLabel, reader);
  }


  @Override
  public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    this.resultSet.updateCharacterStream(columnIndex, x, length);
  }


  @Override
  public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultSet.updateCharacterStream(columnLabel, reader, length);
  }


  @Override
  public void updateClob(int columnIndex, Reader reader) throws SQLException {
    this.resultSet.updateClob(columnIndex, reader);
  }


  @Override
  public void updateClob(String columnLabel, Reader reader) throws SQLException {
    this.resultSet.updateClob(columnLabel, reader);
  }


  @Override
  public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
    this.resultSet.updateClob(columnIndex, reader, length);
  }


  @Override
  public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultSet.updateClob(columnLabel, reader, length);
  }


  @Override
  public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
    this.resultSet.updateNCharacterStream(columnIndex, x);
  }


  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
    this.resultSet.updateNCharacterStream(columnLabel, reader);
  }


  @Override
  public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    this.resultSet.updateNCharacterStream(columnIndex, x, length);
  }


  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultSet.updateNCharacterStream(columnLabel, reader, length);
  }


  @Override
  public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
    this.resultSet.updateNClob(columnIndex, nClob);
  }


  @Override
  public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
    this.resultSet.updateNClob(columnLabel, nClob);
  }


  @Override
  public void updateNClob(int columnIndex, Reader reader) throws SQLException {
    this.resultSet.updateNClob(columnIndex, reader);
  }


  @Override
  public void updateNClob(String columnLabel, Reader reader) throws SQLException {
    this.resultSet.updateNClob(columnLabel, reader);
  }


  @Override
  public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
    this.resultSet.updateNClob(columnIndex, reader, length);
  }


  @Override
  public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
    this.resultSet.updateNClob(columnLabel, reader, length);
  }


  @Override
  public void updateNString(int columnIndex, String nString) throws SQLException {
    this.resultSet.updateNString(columnIndex, nString);
  }


  @Override
  public void updateNString(String columnLabel, String nString) throws SQLException {
    this.resultSet.updateNString(columnLabel, nString);
  }


  @Override
  public void updateRowId(int columnIndex, RowId x) throws SQLException {
    this.resultSet.updateRowId(columnIndex, x);
  }


  @Override
  public void updateRowId(String columnLabel, RowId x) throws SQLException {
    this.resultSet.updateRowId(columnLabel, x);
  }


  @Override
  public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
    this.resultSet.updateSQLXML(columnIndex, xmlObject);
  }


  @Override
  public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
    this.resultSet.updateSQLXML(columnLabel, xmlObject);
  }


  @Override
  public boolean isClosed() throws SQLException {
    return this.resultSet.isClosed();
  }


  @Override
  public int hashCode() {
    return this.resultSet.hashCode();
  }
}
