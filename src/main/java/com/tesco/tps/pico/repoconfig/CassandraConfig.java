package com.tesco.tps.pico.repoconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.config.DataCenterReplication;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

/**
 * @author shashi
 *
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	private static final String KEYSPACE = "my_keyspace";
	private static final String USERNAME = "cassandra";
	private static final String PASSWORD = "cassandra";
	private static final String NODES = "127.0.0.1"; // comma seperated no

	@Bean
	@Override
	public CassandraCqlClusterFactoryBean cluster() {
		CassandraCqlClusterFactoryBean bean = new CassandraCqlClusterFactoryBean();
		bean.setKeyspaceCreations(getKeyspaceCreations());
		bean.setContactPoints(NODES);
		bean.setUsername(USERNAME);
		bean.setPassword(PASSWORD);
		return bean;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "com.tesco.tps.pico" };
	}

	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		List<CreateKeyspaceSpecification> createKeyspaceSpecifications = new ArrayList<CreateKeyspaceSpecification>();
		createKeyspaceSpecifications.add(getKeySpaceSpecification());
		return createKeyspaceSpecifications;
	}

	// Below method creates "my_keyspace" if it doesnt exist.
	@SuppressWarnings("static-access")
	private CreateKeyspaceSpecification getKeySpaceSpecification() {
		CreateKeyspaceSpecification pandaCoopKeyspace = new CreateKeyspaceSpecification();
		DataCenterReplication dcr = new DataCenterReplication("dc1", 3L);
		pandaCoopKeyspace.name(KEYSPACE);
		pandaCoopKeyspace.ifNotExists(true).createKeyspace().withNetworkReplication(dcr);
		return pandaCoopKeyspace;
	}

}
