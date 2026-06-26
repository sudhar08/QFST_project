#set the base image
FROM docker.io/node:18-alpine

#set the working directory
WORKDIR /usr/app

#copy the package.json
COPY ./package.json ./



#install the dependecies
RUN npm install

COPY ./ ./

CMD [ "npm" , "start" ]