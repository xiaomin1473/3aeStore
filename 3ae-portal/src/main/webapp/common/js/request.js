const service = axios.create({
  //baseURL: "http://localhost:8080/",
  timeout: 5000
});



// request interceptor
service.interceptors.request.use(
  config => {
    //开启等待
    $("#wait").attr("class", "wait fadeIn");

    return config;
  },
  error => {
    //结束等待
    wait.className = "wait";

    //return Promise.reject(error);
    return null;
  }
);

service.interceptors.response.use(
  response => {
    //结束等待
    $("#wait").attr("class","wait");
    
  	if(!response){
  		return null;
  	}
    if(response.data.success){
      if(response.data.error){
    	//Vue.prototype.$message.success(response.data.error);
      }
      return response.data;
    }else{
    	Vue.prototype.$message.error(response.data.error);
    }
    return response.data;
  },
  error => {
    //结束等待
    $("#wait").attr("class","wait");

    Vue.prototype.$message.error(error.message);
    if (error.response){
      if(error.response.status===401){
        window.location.href = "/";
      }
    }
    return Promise.reject(error);
  }
);
