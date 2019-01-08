import axios from 'axios'

// create an axios instance
const service = axios.create({
   baseURL: "https://api.3ae.store", // api 的 base_url
   timeout: 5000 // request timeout
 })
 
export default service