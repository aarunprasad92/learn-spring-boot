# Use an existing docker image as base
FROM amazoncorretto:17

# Download and install a dependency

#Specifying the working directory - Any following command will be executed relative to this path in the container
WORKDIR /usr/app

#copy build files in the current working directory to the container file system
#COPY ./ ./

# Tell the image what to do when it starts as a container
CMD ["java -version"]