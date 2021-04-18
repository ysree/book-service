# Zookeeper as ServiceDiscovery
Deploy ZK cluster with multiple book-service nodes in Playground DC/OS environment, and verified the Leader Election and Key-Value Store relevant scenarios as followings:

Start 3 book-service nodes and ZK cluster with 3 ZK nodes
Verify only one ZK node is Leader
Verify only one book-service node is Leader
Stop the book-service Leader node
Verify ZK will elect a new book-service Leader node
Restart the stopped book-service node
Verify operator/access key and org info is retrieved from KV store
Verify you can connect to the restarted book-service node
Stop the ZK Leader node
Verify a new ZK Leader node will be elected
Repeat Step 4~8
Restart the stopped ZK node
Verify restarted ZK node will join the ZK cluster automatically 
