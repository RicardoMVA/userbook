

Error:
org.jboss.weld.exceptions.DeploymentException: WELD-001408: Unsatisfied dependencies for type UserDao with qualifiers @Default
[ERROR]   at injection point [BackedAnnotatedField] @Inject private com.br.userbook.controller.AuthServlet.userDao
[ERROR]   at com.br.userbook.controller.AuthServlet.userDao(AuthServlet.java:0)

Error 2:
Failed to execute goal deploy: {"WFLYCTL0062: Composite operation failed and was rolled back. Steps that failed:" => {"Operation step-1" => {"WFLYCTL0080: Failed services" => {"jboss.deployment.unit.\"userbook-ear.ear\".WeldStartService" => "Failed to start service
[ERROR]     Caused by: org.jboss.weld.exceptions.DeploymentException: WELD-001409: Ambiguous dependencies for type EntityManager with qualifiers @Default
[ERROR]   at injection point [BackedAnnotatedField] @Inject private com.br.userbook.ejb.UserDao.entityManager
[ERROR]   at com.br.userbook.ejb.UserDao.entityManager(UserDao.java:0)
[ERROR]   Possible dependencies:
[ERROR]   - Resource Producer Field [EntityManager] with qualifiers [@Any @Default] declared as [[BackedAnnotatedField] @PersistenceContext @Produces private com.br.userbook.ejb.ResourceProducer.em],
[ERROR]   - Resource Producer Field [EntityManager] with qualifiers [@Any @Default] declared as [[BackedAnnotatedField] @PersistenceContext @Produces private com.br.userbook.ejb.ResourceProducer.em]
[ERROR] "}}}}