# netflix-zuul-api-gateway-server
API gateway server.  Channel requests through this service so it can do logging, authentication, security, etc.  
To use this the URI to the microservice you want must be prepended with 
http://localhost:8765/<service-name>/<service-URI>  where 8765 is the port of this Netflix Zuul API Gateway Server.