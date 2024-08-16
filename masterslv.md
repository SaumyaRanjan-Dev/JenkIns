Jenkins Master (Server)
The Jenkins master server is the central control unit that manages the overall orchestration of workflows defined in pipelines. It handles tasks such as scheduling jobs, monitoring job status, and managing configurations. The master serves the Jenkins UI and acts as the control node, delegating job execution to agents.

Jenkins Agent
A Jenkins agent is a separate machine or container that executes the tasks defined in Jenkins jobs. When a job is triggered on the master, the actual execution occurs on the assigned agent. Each agent is identified by a unique label, allowing the master to delegate jobs to the appropriate agent.

For small teams or projects, a single Jenkins installation may suffice. However, as the number of projects grows, it becomes necessary to scale. Jenkins supports this by allowing a master to connect with multiple agents, enabling distributed job execution.

