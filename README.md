# Java HTTP Server

The HTTP server passes cob spec tests and serves a Ruby TicTacGame.


## Requirement
- maven 3.3.9

## Installation
Clone the repository and package.

```maven pkg```

## Shortcut
Use this bash executable to download all 3 projects together (Server, TTT gem, cob_spec)

## Usage
- Clone git remote) and follow configuration instructions
- Clone the [TTT gem](https://github.com/andarcabrera/tttj_gem) and place it at the same level with the HTTP Server, so it can be accessed by the server
- Run server and pass argument for port number and cob spec public directory (port 5000 is cob_spec default)

``` java -jar [/YOUR/PROJECT/PATH/java/HTTPServer/target/HTTPServer-1.0-SNAPSHOT.jar -p 5000 -d /YOUR/COBSPEC/PATH/cob_spec/public```

