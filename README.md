OSHA Thumbnail generator
========================

##Prerequisites

Java 7 and Maven

    cd /var/local
    wget http://mirrors.hostingromania.ro/apache.org/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz
    tar xzvf apache-maven-3.2.2-bin.tar.gz
    ln -s apache-maven-3.2.2 maven
    export M2_HOME=/var/local/maven
    export PATH=${M2_HOME}/bin:${PATH}

##Build and run project
    git clone https://github.com/melish/oshathumbnailgenerator.git oshathumbnailgenerator
    cd oshathumbnailgenerator
    mvn -Djetty.port=9999 jetty:run-war clean jetty:run-war

##Test
    http://localhost:9999?url=http%3A%2F%2Fwww.wcu.edu%2FUndergraduate_Studies_Presentation.pptx
    http://localhost:8080/thumbnail?url=http%3A%2F%2Fwordnet.dk%2FDanNet_symposium2009_slides_fellbaum.ppt
