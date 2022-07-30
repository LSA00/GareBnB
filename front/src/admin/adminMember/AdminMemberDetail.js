import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useLocation } from 'react-router-dom';

const AdminMemberDetail = () => {
  
  const location = useLocation();

  const [mem_LEV, setMem_LEV] = useState('');

  const mem_idx = location.state.MEM_IDX

  const [getMem, setGetMem] = useState({ // MEM_IDX는 list에서 넘어온 값으로 초기값 지정
    MEM_IDX : mem_idx,
    MEM_ID : '',
    MEM_PW : '',
    MEM_LEVEL : '', 
    MEM_NAME : '',
    MEM_PHONE : ''
  });

 useEffect(() =>{ // 해당 MEM_IDX로 나머지 정보 가져옴
        axios({ 
        method : 'post',
        url : '/GareBnB/Admin/MemDetail.do', 
        contentType:"application/json; charset=UTF-8",
        params : { 
            MEM_IDX : getMem.MEM_IDX
        }})

    .then(Response => {  
    console.log(Response.data);
    setGetMem(Response.data);
    setMem_LEV(Response.data.MEM_LEVEL);
  })
  },[]); 


    const [memDenyModify , setMemDenyModify] = useState();
    const adminModifySuccess = () => { // 저장 버튼 클릭 시 update sql문 실행됨 (레벨 업데이트 - 정지) // 정지는 영정 
      axios({
      method : 'post',
      url : '/GareBnB/Admin/memberDeny.do',
      contentType:"apllication/json; charset=UTF-8",
      params : {
        MEM_IDX : getMem.MEM_IDX 
      } })
    .then(Response => {
      console.log(Response.data);
      setMemDenyModify(Response.data);
    })
    }
   
    const onClick = () => { // 회원 정지 업데이트 클릭하면 멤버 레벨 : 5로 띄워줌 (확인 버튼 눌러야 DB에 적용됨)
      setMem_LEV (5)
    }

  return (
    <article>
      <h1>{getMem.MEM_ID} 회원 상세보기</h1>
      <p/>
      <ul>
      <h3>일반 회원 정보</h3>
      <li>번호(IDX) : {getMem.MEM_IDX}</li>
      <li>아이디 :{getMem.MEM_ID} </li>
      <li>비밀번호 : {getMem.MEM_PW} </li>
      <li>이름 : {getMem.MEM_NAME} </li>
      <li>휴대폰 번호 : {getMem.MEM_PHONE}</li>
      <li>level(임시) : {mem_LEV}</li>
      <p/>
      <h3>호스트 회원 정보</h3>
      <li>호스트프로필사진: </li>
      <li>이메일 : {getMem.HOST_EMAIL}</li>
      <li>우편번호 : {getMem.HOST_POSTCODE}</li>
      <li>주소 : {getMem.HOST_ADDR1}</li>
      <li>상세주소 : {getMem.HOST_ADDR2}</li>
      <li>주민번호 : {getMem.HOST_JUMIN1}-{getMem.HOST_JUMIN2}</li>
      <li>소개 : {getMem.HOST_INTRO}</li>
      <li>은행 : {getMem.HOST_ACCOUNT}</li>
      <li>계좌번호 : {getMem.HOST_BANK}</li>


      <p/><p/>
      <button type="submit" onClick={onClick}> 회원 정지 업데이트 </button>
      <Link to = '/admin/adminMemberList'><button onClick={adminModifySuccess}>확인</button></Link>
      <Link to = '/admin/adminMemberList'><button>취소</button></Link>
      </ul>
      </article>
  );
    }

export default AdminMemberDetail

