import axios from 'axios'
const service = axios.create({
   baseURL: "https://api.3ae.store", // api 的 base_url
   timeout: 5000 // request timeout
 })
 
 service.get('/mall/goods/category')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });