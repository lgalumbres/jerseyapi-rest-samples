jerseyapi-rest-samples
=======================

A sample rest service using Jersey API.

Requirements
------------

[Apache ANT](http://ant.apache.org/) - To compile source files and package war files.

List of ANT task
----------------

- compile - Task to compile source files.
 
```shell
ant compile 
```

- build - Task compiles sources files and packages war files.

```shell
ant build
```

- deploy - Task that deploys packaged war file to specified location in ${deploy.dir} in the build.properties file.

```shell
ant deploy
```

- clean - Task that cleans build and dist directories.

```shell
ant clean
```

- create - Task that creates build and dist directories.

```shell
ant clean
```

