package org.jdbc.adapter.jdbc42;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.jdbc.adapter.iface.ConnectionWrapper;
import org.jdbc.adapter.iface.DatabaseMetaDataWrapper;
import org.jdbc.adapter.iface.ResultSetWrapper;
import org.jdbc.adapter.iface.StatementWrapper;

/**
 * @author David Matějček
 */
public class Jdbc42DatabaseMetaData implements DatabaseMetaDataWrapper {

  private static final Logger LOG = Logger.getLogger(Jdbc42DatabaseMetaData.class.getName());

  private final DatabaseMetaData metaData;
  private final ConnectionWrapper connection;


  /**
   * @param metaData
   * @param connection
   */
  public Jdbc42DatabaseMetaData(final DatabaseMetaData metaData, final ConnectionWrapper connection) {
    this.metaData = metaData;
    this.connection = connection;
  }


  @Override
  public ResultSetWrapper wrap(final ResultSet resultSet) throws SQLException {
    LOG.entering(getClass().getSimpleName(), "wrap", resultSet);
    if (resultSet == null) {
      return null;
    }
    return new Jdbc42ResultSet(resultSet, wrap(resultSet.getStatement()));
  }


  @Override
  public StatementWrapper wrap(final Statement statement) throws SQLException {
    LOG.entering(getClass().getSimpleName(), "wrap", statement);
    if (statement == null) {
      return null;
    }
    return new Jdbc42Statement(statement, connection);
  }


  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return iface.isInstance(this) || iface.isInstance(this.metaData) || this.metaData.isWrapperFor(iface);
  }


  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    if (iface.isInstance(this.metaData)) {
      return iface.cast(this.metaData);
    }
    return this.metaData.unwrap(iface);
  }


  @Override
  public boolean allProceduresAreCallable() throws SQLException {
    return this.metaData.allProceduresAreCallable();
  }


  @Override
  public boolean allTablesAreSelectable() throws SQLException {
    return this.metaData.allTablesAreSelectable();
  }


  @Override
  public String getURL() throws SQLException {
    return this.metaData.getURL();
  }


  @Override
  public String getUserName() throws SQLException {
    return this.metaData.getUserName();
  }


  @Override
  public boolean isReadOnly() throws SQLException {
    return this.metaData.isReadOnly();
  }


  @Override
  public boolean nullsAreSortedHigh() throws SQLException {
    return this.metaData.nullsAreSortedHigh();
  }


  @Override
  public boolean nullsAreSortedLow() throws SQLException {
    return this.metaData.nullsAreSortedLow();
  }


  @Override
  public boolean nullsAreSortedAtStart() throws SQLException {
    return this.metaData.nullsAreSortedAtStart();
  }


  @Override
  public boolean nullsAreSortedAtEnd() throws SQLException {
    return this.metaData.nullsAreSortedAtEnd();
  }


  @Override
  public String getDatabaseProductName() throws SQLException {
    return this.metaData.getDatabaseProductName();
  }


  @Override
  public String getDatabaseProductVersion() throws SQLException {
    return this.metaData.getDatabaseProductVersion();
  }


  @Override
  public String getDriverName() throws SQLException {
    return this.metaData.getDriverName();
  }


  @Override
  public String getDriverVersion() throws SQLException {
    return this.metaData.getDriverVersion();
  }


  @Override
  public int getDriverMajorVersion() {
    return this.metaData.getDriverMajorVersion();
  }


  @Override
  public int getDriverMinorVersion() {
    return this.metaData.getDriverMinorVersion();
  }


  @Override
  public boolean usesLocalFiles() throws SQLException {
    return this.metaData.usesLocalFiles();
  }


  @Override
  public boolean usesLocalFilePerTable() throws SQLException {
    return this.metaData.usesLocalFilePerTable();
  }


  @Override
  public boolean supportsMixedCaseIdentifiers() throws SQLException {
    return this.metaData.supportsMixedCaseIdentifiers();
  }


  @Override
  public boolean storesUpperCaseIdentifiers() throws SQLException {
    return this.metaData.storesUpperCaseIdentifiers();
  }


  @Override
  public boolean storesLowerCaseIdentifiers() throws SQLException {
    return this.metaData.storesLowerCaseIdentifiers();
  }


  @Override
  public boolean storesMixedCaseIdentifiers() throws SQLException {
    return this.metaData.storesMixedCaseIdentifiers();
  }


  @Override
  public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
    return this.metaData.supportsMixedCaseQuotedIdentifiers();
  }


  @Override
  public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
    return this.metaData.storesUpperCaseQuotedIdentifiers();
  }


  @Override
  public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
    return this.metaData.storesLowerCaseQuotedIdentifiers();
  }


  @Override
  public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
    return this.metaData.storesMixedCaseQuotedIdentifiers();
  }


  @Override
  public String getIdentifierQuoteString() throws SQLException {
    return this.metaData.getIdentifierQuoteString();
  }


  @Override
  public String getSQLKeywords() throws SQLException {
    return this.metaData.getSQLKeywords();
  }


  @Override
  public String getNumericFunctions() throws SQLException {
    return this.metaData.getNumericFunctions();
  }


  @Override
  public String getStringFunctions() throws SQLException {
    return this.metaData.getStringFunctions();
  }


  @Override
  public String getSystemFunctions() throws SQLException {
    return this.metaData.getSystemFunctions();
  }


  @Override
  public String getTimeDateFunctions() throws SQLException {
    return this.metaData.getTimeDateFunctions();
  }


  @Override
  public String getSearchStringEscape() throws SQLException {
    return this.metaData.getSearchStringEscape();
  }


  @Override
  public String getExtraNameCharacters() throws SQLException {
    return this.metaData.getExtraNameCharacters();
  }


  @Override
  public boolean supportsAlterTableWithAddColumn() throws SQLException {
    return this.metaData.supportsAlterTableWithAddColumn();
  }


  @Override
  public boolean supportsAlterTableWithDropColumn() throws SQLException {
    return this.metaData.supportsAlterTableWithDropColumn();
  }


  @Override
  public boolean supportsColumnAliasing() throws SQLException {
    return this.metaData.supportsColumnAliasing();
  }


  @Override
  public boolean nullPlusNonNullIsNull() throws SQLException {
    return this.metaData.nullPlusNonNullIsNull();
  }


  @Override
  public boolean supportsConvert() throws SQLException {
    return this.metaData.supportsConvert();
  }


  @Override
  public boolean supportsConvert(final int fromType, final int toType) throws SQLException {
    return this.metaData.supportsConvert(fromType, toType);
  }


  @Override
  public boolean supportsTableCorrelationNames() throws SQLException {
    return this.metaData.supportsTableCorrelationNames();
  }


  @Override
  public boolean supportsDifferentTableCorrelationNames() throws SQLException {
    return this.metaData.supportsDifferentTableCorrelationNames();
  }


  @Override
  public boolean supportsExpressionsInOrderBy() throws SQLException {
    return this.metaData.supportsExpressionsInOrderBy();
  }


  @Override
  public boolean supportsOrderByUnrelated() throws SQLException {
    return this.metaData.supportsOrderByUnrelated();
  }


  @Override
  public boolean supportsGroupBy() throws SQLException {
    return this.metaData.supportsGroupBy();
  }


  @Override
  public boolean supportsGroupByUnrelated() throws SQLException {
    return this.metaData.supportsGroupByUnrelated();
  }


  @Override
  public boolean supportsGroupByBeyondSelect() throws SQLException {
    return this.metaData.supportsGroupByBeyondSelect();
  }


  @Override
  public boolean supportsLikeEscapeClause() throws SQLException {
    return this.metaData.supportsLikeEscapeClause();
  }


  @Override
  public boolean supportsMultipleResultSets() throws SQLException {
    return this.metaData.supportsMultipleResultSets();
  }


  @Override
  public boolean supportsMultipleTransactions() throws SQLException {
    return this.metaData.supportsMultipleTransactions();
  }


  @Override
  public boolean supportsNonNullableColumns() throws SQLException {
    return this.metaData.supportsNonNullableColumns();
  }


  @Override
  public boolean supportsMinimumSQLGrammar() throws SQLException {
    return this.metaData.supportsMinimumSQLGrammar();
  }


  @Override
  public boolean supportsCoreSQLGrammar() throws SQLException {
    return this.metaData.supportsCoreSQLGrammar();
  }


  @Override
  public boolean supportsExtendedSQLGrammar() throws SQLException {
    return this.metaData.supportsExtendedSQLGrammar();
  }


  @Override
  public boolean supportsANSI92EntryLevelSQL() throws SQLException {
    return this.metaData.supportsANSI92EntryLevelSQL();
  }


  @Override
  public boolean supportsANSI92IntermediateSQL() throws SQLException {
    return this.metaData.supportsANSI92IntermediateSQL();
  }


  @Override
  public boolean supportsANSI92FullSQL() throws SQLException {
    return this.metaData.supportsANSI92FullSQL();
  }


  @Override
  public boolean supportsIntegrityEnhancementFacility() throws SQLException {
    return this.metaData.supportsIntegrityEnhancementFacility();
  }


  @Override
  public boolean supportsOuterJoins() throws SQLException {
    return this.metaData.supportsOuterJoins();
  }


  @Override
  public boolean supportsFullOuterJoins() throws SQLException {
    return this.metaData.supportsFullOuterJoins();
  }


  @Override
  public boolean supportsLimitedOuterJoins() throws SQLException {
    return this.metaData.supportsLimitedOuterJoins();
  }


  @Override
  public String getSchemaTerm() throws SQLException {
    return this.metaData.getSchemaTerm();
  }


  @Override
  public String getProcedureTerm() throws SQLException {
    return this.metaData.getProcedureTerm();
  }


  @Override
  public String getCatalogTerm() throws SQLException {
    return this.metaData.getCatalogTerm();
  }


  @Override
  public boolean isCatalogAtStart() throws SQLException {
    return this.metaData.isCatalogAtStart();
  }


  @Override
  public String getCatalogSeparator() throws SQLException {
    return this.metaData.getCatalogSeparator();
  }


  @Override
  public boolean supportsSchemasInDataManipulation() throws SQLException {
    return this.metaData.supportsSchemasInDataManipulation();
  }


  @Override
  public boolean supportsSchemasInProcedureCalls() throws SQLException {
    return this.metaData.supportsSchemasInProcedureCalls();
  }


  @Override
  public boolean supportsSchemasInTableDefinitions() throws SQLException {
    return this.metaData.supportsSchemasInTableDefinitions();
  }


  @Override
  public boolean supportsSchemasInIndexDefinitions() throws SQLException {
    return this.metaData.supportsSchemasInIndexDefinitions();
  }


  @Override
  public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
    return this.metaData.supportsSchemasInPrivilegeDefinitions();
  }


  @Override
  public boolean supportsCatalogsInDataManipulation() throws SQLException {
    return this.metaData.supportsCatalogsInDataManipulation();
  }


  @Override
  public boolean supportsCatalogsInProcedureCalls() throws SQLException {
    return this.metaData.supportsCatalogsInProcedureCalls();
  }


  @Override
  public boolean supportsCatalogsInTableDefinitions() throws SQLException {
    return this.metaData.supportsCatalogsInTableDefinitions();
  }


  @Override
  public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
    return this.metaData.supportsCatalogsInIndexDefinitions();
  }


  @Override
  public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
    return this.metaData.supportsCatalogsInPrivilegeDefinitions();
  }


  @Override
  public boolean supportsPositionedDelete() throws SQLException {
    return this.metaData.supportsPositionedDelete();
  }


  @Override
  public boolean supportsPositionedUpdate() throws SQLException {
    return this.metaData.supportsPositionedUpdate();
  }


  @Override
  public boolean supportsSelectForUpdate() throws SQLException {
    return this.metaData.supportsSelectForUpdate();
  }


  @Override
  public boolean supportsStoredProcedures() throws SQLException {
    return this.metaData.supportsStoredProcedures();
  }


  @Override
  public boolean supportsSubqueriesInComparisons() throws SQLException {
    return this.metaData.supportsSubqueriesInComparisons();
  }


  @Override
  public boolean supportsSubqueriesInExists() throws SQLException {
    return this.metaData.supportsSubqueriesInExists();
  }


  @Override
  public boolean supportsSubqueriesInIns() throws SQLException {
    return this.metaData.supportsSubqueriesInIns();
  }


  @Override
  public boolean supportsSubqueriesInQuantifieds() throws SQLException {
    return this.metaData.supportsSubqueriesInQuantifieds();
  }


  @Override
  public boolean supportsCorrelatedSubqueries() throws SQLException {
    return this.metaData.supportsCorrelatedSubqueries();
  }


  @Override
  public boolean supportsUnion() throws SQLException {
    return this.metaData.supportsUnion();
  }


  @Override
  public boolean supportsUnionAll() throws SQLException {
    return this.metaData.supportsUnionAll();
  }


  @Override
  public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
    return this.metaData.supportsOpenCursorsAcrossCommit();
  }


  @Override
  public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
    return this.metaData.supportsOpenCursorsAcrossRollback();
  }


  @Override
  public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
    return this.metaData.supportsOpenStatementsAcrossCommit();
  }


  @Override
  public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
    return this.metaData.supportsOpenStatementsAcrossRollback();
  }


  @Override
  public int getMaxBinaryLiteralLength() throws SQLException {
    return this.metaData.getMaxBinaryLiteralLength();
  }


  @Override
  public int getMaxCharLiteralLength() throws SQLException {
    return this.metaData.getMaxCharLiteralLength();
  }


  @Override
  public int getMaxColumnNameLength() throws SQLException {
    return this.metaData.getMaxColumnNameLength();
  }


  @Override
  public int getMaxColumnsInGroupBy() throws SQLException {
    return this.metaData.getMaxColumnsInGroupBy();
  }


  @Override
  public int getMaxColumnsInIndex() throws SQLException {
    return this.metaData.getMaxColumnsInIndex();
  }


  @Override
  public int getMaxColumnsInOrderBy() throws SQLException {
    return this.metaData.getMaxColumnsInOrderBy();
  }


  @Override
  public int getMaxColumnsInSelect() throws SQLException {
    return this.metaData.getMaxColumnsInSelect();
  }


  @Override
  public int getMaxColumnsInTable() throws SQLException {
    return this.metaData.getMaxColumnsInTable();
  }


  @Override
  public int getMaxConnections() throws SQLException {
    return this.metaData.getMaxConnections();
  }


  @Override
  public int getMaxCursorNameLength() throws SQLException {
    return this.metaData.getMaxCursorNameLength();
  }


  @Override
  public int getMaxIndexLength() throws SQLException {
    return this.metaData.getMaxIndexLength();
  }


  @Override
  public int getMaxSchemaNameLength() throws SQLException {
    return this.metaData.getMaxSchemaNameLength();
  }


  @Override
  public int getMaxProcedureNameLength() throws SQLException {
    return this.metaData.getMaxProcedureNameLength();
  }


  @Override
  public int getMaxCatalogNameLength() throws SQLException {
    return this.metaData.getMaxCatalogNameLength();
  }


  @Override
  public int getMaxRowSize() throws SQLException {
    return this.metaData.getMaxRowSize();
  }


  @Override
  public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
    return this.metaData.doesMaxRowSizeIncludeBlobs();
  }


  @Override
  public int getMaxStatementLength() throws SQLException {
    return this.metaData.getMaxStatementLength();
  }


  @Override
  public int getMaxStatements() throws SQLException {
    return this.metaData.getMaxStatements();
  }


  @Override
  public int getMaxTableNameLength() throws SQLException {
    return this.metaData.getMaxTableNameLength();
  }


  @Override
  public int getMaxTablesInSelect() throws SQLException {
    return this.metaData.getMaxTablesInSelect();
  }


  @Override
  public int getMaxUserNameLength() throws SQLException {
    return this.metaData.getMaxUserNameLength();
  }


  @Override
  public int getDefaultTransactionIsolation() throws SQLException {
    return this.metaData.getDefaultTransactionIsolation();
  }


  @Override
  public boolean supportsTransactions() throws SQLException {
    return this.metaData.supportsTransactions();
  }


  @Override
  public boolean supportsTransactionIsolationLevel(final int level) throws SQLException {
    return this.metaData.supportsTransactionIsolationLevel(level);
  }


  @Override
  public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
    return this.metaData.supportsDataDefinitionAndDataManipulationTransactions();
  }


  @Override
  public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
    return this.metaData.supportsDataManipulationTransactionsOnly();
  }


  @Override
  public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
    return this.metaData.dataDefinitionCausesTransactionCommit();
  }


  @Override
  public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
    return this.metaData.dataDefinitionIgnoredInTransactions();
  }


  @Override
  public ResultSet getProcedures(final String catalog, final String schemaPattern, final String procedureNamePattern)
    throws SQLException {
    return this.metaData.getProcedures(catalog, schemaPattern, procedureNamePattern);
  }


  @Override
  public ResultSet getProcedureColumns(final String catalog, final String schemaPattern,
      final String procedureNamePattern, final String columnNamePattern) throws SQLException {
    return this.metaData.getProcedureColumns(catalog, schemaPattern, procedureNamePattern, columnNamePattern);
  }


  @Override
  public ResultSet getTables(final String catalog, final String schemaPattern, final String tableNamePattern,
      final String[] types) throws SQLException {
    return this.metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
  }


  @Override
  public ResultSet getSchemas() throws SQLException {
    return this.metaData.getSchemas();
  }


  @Override
  public ResultSet getCatalogs() throws SQLException {
    return this.metaData.getCatalogs();
  }


  @Override
  public ResultSet getTableTypes() throws SQLException {
    return this.metaData.getTableTypes();
  }


  @Override
  public ResultSet getColumns(final String catalog, final String schemaPattern, final String tableNamePattern,
      final String columnNamePattern) throws SQLException {
    return this.metaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
  }


  @Override
  public ResultSet getColumnPrivileges(final String catalog, final String schema, final String table,
      final String columnNamePattern) throws SQLException {
    return this.metaData.getColumnPrivileges(catalog, schema, table, columnNamePattern);
  }


  @Override
  public ResultSet getTablePrivileges(final String catalog, final String schemaPattern, final String tableNamePattern)
    throws SQLException {
    return this.metaData.getTablePrivileges(catalog, schemaPattern, tableNamePattern);
  }


  @Override
  public ResultSet getBestRowIdentifier(final String catalog, final String schema, final String table, final int scope,
      final boolean nullable) throws SQLException {
    return this.metaData.getBestRowIdentifier(catalog, schema, table, scope, nullable);
  }


  @Override
  public ResultSet getVersionColumns(final String catalog, final String schema, final String table)
    throws SQLException {
    return this.metaData.getVersionColumns(catalog, schema, table);
  }


  @Override
  public ResultSet getPrimaryKeys(final String catalog, final String schema, final String table) throws SQLException {
    return this.metaData.getPrimaryKeys(catalog, schema, table);
  }


  @Override
  public ResultSet getImportedKeys(final String catalog, final String schema, final String table) throws SQLException {
    return this.metaData.getImportedKeys(catalog, schema, table);
  }


  @Override
  public ResultSet getExportedKeys(final String catalog, final String schema, final String table) throws SQLException {
    return this.metaData.getExportedKeys(catalog, schema, table);
  }


  @Override
  public ResultSet getCrossReference(final String parentCatalog, final String parentSchema, final String parentTable,
      final String foreignCatalog, final String foreignSchema, final String foreignTable) throws SQLException {
    return this.metaData.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog, foreignSchema,
        foreignTable);
  }


  @Override
  public ResultSet getTypeInfo() throws SQLException {
    return this.metaData.getTypeInfo();
  }


  @Override
  public ResultSet getIndexInfo(final String catalog, final String schema, final String table, final boolean unique,
      final boolean approximate) throws SQLException {
    return this.metaData.getIndexInfo(catalog, schema, table, unique, approximate);
  }


  @Override
  public boolean supportsResultSetType(final int type) throws SQLException {
    return this.metaData.supportsResultSetType(type);
  }


  @Override
  public boolean supportsResultSetConcurrency(final int type, final int concurrency) throws SQLException {
    return this.metaData.supportsResultSetConcurrency(type, concurrency);
  }


  @Override
  public boolean ownUpdatesAreVisible(final int type) throws SQLException {
    return this.metaData.ownUpdatesAreVisible(type);
  }


  @Override
  public boolean ownDeletesAreVisible(final int type) throws SQLException {
    return this.metaData.ownDeletesAreVisible(type);
  }


  @Override
  public boolean ownInsertsAreVisible(final int type) throws SQLException {
    return this.metaData.ownInsertsAreVisible(type);
  }


  @Override
  public boolean othersUpdatesAreVisible(final int type) throws SQLException {
    return this.metaData.othersUpdatesAreVisible(type);
  }


  @Override
  public boolean othersDeletesAreVisible(final int type) throws SQLException {
    return this.metaData.othersDeletesAreVisible(type);
  }


  @Override
  public boolean othersInsertsAreVisible(final int type) throws SQLException {
    return this.metaData.othersInsertsAreVisible(type);
  }


  @Override
  public boolean updatesAreDetected(final int type) throws SQLException {
    return this.metaData.updatesAreDetected(type);
  }


  @Override
  public boolean deletesAreDetected(final int type) throws SQLException {
    return this.metaData.deletesAreDetected(type);
  }


  @Override
  public boolean insertsAreDetected(final int type) throws SQLException {
    return this.metaData.insertsAreDetected(type);
  }


  @Override
  public boolean supportsBatchUpdates() throws SQLException {
    return this.metaData.supportsBatchUpdates();
  }


  @Override
  public ResultSet getUDTs(final String catalog, final String schemaPattern, final String typeNamePattern,
      final int[] types) throws SQLException {
    return this.metaData.getUDTs(catalog, schemaPattern, typeNamePattern, types);
  }


  /**
   * @return parent connection (wrapper)
   * @throws SQLException
   */
  @Override
  public ConnectionWrapper getConnection() throws SQLException {
    return this.connection;
  }


  @Override
  public boolean supportsSavepoints() throws SQLException {
    return this.metaData.supportsSavepoints();
  }


  @Override
  public boolean supportsNamedParameters() throws SQLException {
    return this.metaData.supportsNamedParameters();
  }


  @Override
  public boolean supportsMultipleOpenResults() throws SQLException {
    return this.metaData.supportsMultipleOpenResults();
  }


  @Override
  public boolean supportsGetGeneratedKeys() throws SQLException {
    return this.metaData.supportsGetGeneratedKeys();
  }


  @Override
  public ResultSet getSuperTypes(final String catalog, final String schemaPattern, final String typeNamePattern)
    throws SQLException {
    return this.metaData.getSuperTypes(catalog, schemaPattern, typeNamePattern);
  }


  @Override
  public ResultSet getSuperTables(final String catalog, final String schemaPattern, final String tableNamePattern)
    throws SQLException {
    return this.metaData.getSuperTables(catalog, schemaPattern, tableNamePattern);
  }


  @Override
  public ResultSet getAttributes(final String catalog, final String schemaPattern, final String typeNamePattern,
      final String attributeNamePattern) throws SQLException {
    return this.metaData.getAttributes(catalog, schemaPattern, typeNamePattern, attributeNamePattern);
  }


  @Override
  public boolean supportsResultSetHoldability(final int holdability) throws SQLException {
    return this.metaData.supportsResultSetHoldability(holdability);
  }


  @Override
  public int getResultSetHoldability() throws SQLException {
    return this.metaData.getResultSetHoldability();
  }


  @Override
  public int getDatabaseMajorVersion() throws SQLException {
    return this.metaData.getDatabaseMajorVersion();
  }


  @Override
  public int getDatabaseMinorVersion() throws SQLException {
    return this.metaData.getDatabaseMinorVersion();
  }


  @Override
  public int getJDBCMajorVersion() throws SQLException {
    return this.metaData.getJDBCMajorVersion();
  }


  @Override
  public int getJDBCMinorVersion() throws SQLException {
    return this.metaData.getJDBCMinorVersion();
  }


  @Override
  public int getSQLStateType() throws SQLException {
    return this.metaData.getSQLStateType();
  }


  @Override
  public boolean locatorsUpdateCopy() throws SQLException {
    return this.metaData.locatorsUpdateCopy();
  }


  @Override
  public boolean supportsStatementPooling() throws SQLException {
    return this.metaData.supportsStatementPooling();
  }


  @Override
  public RowIdLifetime getRowIdLifetime() throws SQLException {
    return this.metaData.getRowIdLifetime();
  }


  @Override
  public ResultSet getSchemas(final String catalog, final String schemaPattern) throws SQLException {
    return this.metaData.getSchemas(catalog, schemaPattern);
  }


  @Override
  public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
    return this.metaData.supportsStoredFunctionsUsingCallSyntax();
  }


  @Override
  public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
    return this.metaData.autoCommitFailureClosesAllResultSets();
  }


  @Override
  public ResultSet getClientInfoProperties() throws SQLException {
    return wrap(this.metaData.getClientInfoProperties());
  }


  @Override
  public ResultSet getFunctions(final String catalog, final String schemaPattern, final String functionNamePattern)
    throws SQLException {
    return wrap(this.metaData.getFunctions(catalog, schemaPattern, functionNamePattern));
  }


  @Override
  public ResultSet getFunctionColumns(final String catalog, final String schemaPattern,
      final String functionNamePattern, final String columnNamePattern) throws SQLException {
    return this.metaData.getFunctionColumns(catalog, schemaPattern, functionNamePattern, columnNamePattern);
  }


  @Override
  public ResultSet getPseudoColumns(final String catalog, final String schemaPattern, final String tableNamePattern,
      final String columnNamePattern) throws SQLException {
    return this.metaData.getPseudoColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
  }


  @Override
  public boolean generatedKeyAlwaysReturned() throws SQLException {
    return this.metaData.generatedKeyAlwaysReturned();
  }
}
