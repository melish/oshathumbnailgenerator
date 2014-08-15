OSHA Thumbnail generator
========================

##Prerequisites

1. Java 7
2. Maven
    cd /var/local
    wget http://mirrors.hostingromania.ro/apache.org/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz
    tar xzvf apache-maven-3.2.2-bin.tar.gz
    ln -s apache-maven-3.2.2 maven
    export M2_HOME=/var/local/maven
    export PATH=${M2_HOME}/bin:${PATH}

##Build and run project
    git clone git@github.com:melish/oshathumbnailgenerator.git oshathumbnailgenerator
    cd oshathumbnailgenerator
    mvn clean jetty:run-war

##Test
    http://localhost:8080/thumbnail?url=http%3A%2F%2Fwww.wcu.edu%2FUndergraduate_Studies_Presentation.pptx