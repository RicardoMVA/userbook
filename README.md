<h1>Deploy attempt</h1>

<p>This is an attempt to deploy the project to a Digital Ocean droplet running Ubuntu 18.04. The droplet is currently up in the http://157.245.227.112:8080/ address with a working instance of a Wildfly 18 server running.
<br>
Unfortunately, many bugs have appeared in the build process, and they couldn't be resolved before the deadline, so the deploy was not possible.
<br>
Here are the bugs encountered, when trying to do the build process using the command <code>mvn org.wildfly.plugins:wildfly-maven-plugin:deploy</code></p>

<br>

<p><strong>Error 1:</strong></p>
<code>org.jboss.weld.exceptions.DeploymentException: WELD-001408: Unsatisfied dependencies for type UserDao with qualifiers @Default
[ERROR]   at injection point [BackedAnnotatedField] @Inject private com.br.userbook.controller.AuthServlet.userDao
[ERROR]   at com.br.userbook.controller.AuthServlet.userDao(AuthServlet.java:0)</code>

<br>

<p><strong>Error 2:</strong></p>
<code>Failed to execute goal deploy: {"WFLYCTL0062: Composite operation failed and was rolled back. Steps that failed:" => {"Operation step-1" => {"WFLYCTL0080: Failed services" => {"jboss.deployment.unit.\"userbook-ear.ear\".WeldStartService" => "Failed to start service
[ERROR]     Caused by: org.jboss.weld.exceptions.DeploymentException: WELD-001409: Ambiguous dependencies for type EntityManager with qualifiers @Default
[ERROR]   at injection point [BackedAnnotatedField] @Inject private com.br.userbook.ejb.UserDao.entityManager
[ERROR]   at com.br.userbook.ejb.UserDao.entityManager(UserDao.java:0)
[ERROR]   Possible dependencies:
[ERROR]   - Resource Producer Field [EntityManager] with qualifiers [@Any @Default] declared as [[BackedAnnotatedField] @PersistenceContext @Produces private com.br.userbook.ejb.ResourceProducer.em],
[ERROR]   - Resource Producer Field [EntityManager] with qualifiers [@Any @Default] declared as [[BackedAnnotatedField] @PersistenceContext @Produces private com.br.userbook.ejb.ResourceProducer.em]
[ERROR] "}}}}</code>

<br>

<strong>Error 3:</strong>
<p>This one is especially weird since it appeared when there wasn't any obvious changes to the POM files used in the project, and no attempt to fix it worked.</p>
<code>[ERROR] Failed to execute goal on project userbook-web: Could not resolve dependencies for project com.br.userbook:userbook-web:war:1.0.0-SNAPSHOT: Could not find artifact com.br.userbook:userbook-ejb:jar:1.0.0-SNAPSHOT -> [Help 1]</code>