<template>
  <div class="home">
    <table>
      <tr>
        <th>name</th>
        <th>grade</th>
        <th>department</th>
        <th>address</th>
        <th>phone</th>
        <th>삭제</th>
        <th>수정</th>
      </tr>
      <tr v-for="i in studentList.length" :key="i">
        <td>{{studentList[i-1].s_name}}</td>
        <td>{{studentList[i-1].s_grade}}</td>
        <td>{{studentList[i-1].s_department}}</td>
        <td>{{studentList[i-1].s_address}}</td>
        <td>{{studentList[i-1].s_phone}}</td>
        <td><button v-on:click="deleteStudent(studentList[i-1].s_id)">삭제</button></td>
        <td><button v-on:click="getStudentOne(studentList[i-1].s_id)">수정</button></td>
      </tr>
    </table>
    
    <div> 
      <p>학생 등록</p>
      <input type="text" v-model="name" placeholder="이름을 입력하세요"/>
      <input type="number" v-model="grade" placeholder="학년을 입력하세요"/>
      <input type="text" v-model="department" placeholder="학과를 입력하세요"/>
      <input type="text" v-model="address" placeholder="주소를 입력하세요"/>
      <input type="text" v-model="phone" placeholder="핸드폰 번호를 입력하세요"/>
      <button v-on:click="addStudent">등록</button>
    </div>
    
    <div>
      <p>학생 수정</p>
      <input type="text" v-model="updateName" placeholder="이름을 입력하세요"/>
      <input type="number" v-model="updateGrade" placeholder="학년을 입력하세요"/>
      <input type="text" v-model="updateDepartment" placeholder="학과를 입력하세요"/>
      <input type="text" v-model="updateAddress" placeholder="주소를 입력하세요"/>
      <input type="text" v-model="updatePhone" placeholder="핸드폰 번호를 입력하세요"/>
      <button v-on:click="updateStudent(updateId)">등록</button>
    </div>
  </div>
</template>

<script>
// import http from '../services/http-common.js';
import http from "../services/http-common.js"

export default {
  name: "Home",
  components: {
      
  },

  data(){
    return {
      studentList : [],
      name : '',
      grade : 1,
      department : '',
      address : '',
      phone : '',
      
      updateId : '',
      updateName : '',
      updateGrade : 1,
      updateDepartment : '',
      updateAddress : '',
      updatePhone : '',
    }
  },

  methods: {
    getStudent(){
      http
        .get("/Student")
        .then(Response => (this.studentList = Response.data))
        .catch(error => {
          console.log(error);
        });
    },
    addStudent(){
      http
        .post("/Student", {s_name:this.name, s_grade:this.grade, s_department:this.department,
        s_address:this.address, s_phone:this.phone})
        .then(Response => {
          this.studentList = Response.data
          })
        .catch(error => {
          console.log(error);
        });
      this.name = "", this.grade = 1, this.department = "",
      this.address = "", this.phone = "";
    },
    deleteStudent(id){
      http
        .delete(`/Student/${id}`)
        .then(Response => {
          this.studentList = Response.data
          })
        .catch(error => {
          console.log(error);
        });
    },
    getStudentOne(id){
      http
        .get(`/Student/${id}`)
        .then(Response =>{
          this.updateId = Response.data.s_id, this.updateName = Response.data.s_name,
          this.updateGrade = Response.data.s_grade, this.updateDepartment = Response.data.s_department,
          this.updateAddress = Response.data.s_address, this.updatePhone = Response.data.s_phone
        })
        .catch(error => {
          console.log(error);
        })
    },
    updateStudent(id){
      http
        .put("/Student", {s_id:`${id}`, s_name:this.updateName, s_grade:this.updateGrade, s_department:this.updateDepartment,
        s_address:this.updateAddress, s_phone:this.updatePhone})
        .then(Response => {
          this.studentList = Response.data
          })
        .catch(error => {
          console.log(error);
        });
      this.updateId = 0, this.updateName = "", this.updateDepartment = "",
      this.updateGrade = 1, this.updateAddress = "", this.updatePhone = "";
    },
    
  },

  mounted() {
    this.getStudent()
  }
};
</script>
