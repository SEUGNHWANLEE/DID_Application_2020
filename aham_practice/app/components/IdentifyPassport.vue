<template>
  <Page>
    <FlexboxLayout class="background">
      <FlexboxLayout width="*" height="*" flexDirection="column">
        <FlexboxLayout>
          <label>종류 / Type</label>
          <TextField id="info" v-model="Type" hint="PM"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>여권번호 / Passport No.</label>
          <TextField id="info" v-model="PassportNo" hint="M12312345"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>성 / Surname</label>
          <TextField id="info" v-model="Surname" hint="HONG"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>이름 / Given Names</label>
          <TextField id="info" v-model="GivenNames" hint="GIL DONG"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>국적 / Nationality</label>
          <TextField id="info" v-model="Nationality" hint="REPUBLIC OF KOREA"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>생년월일 / Date of birth</label>
          <TextField id="info" v-model="Bdate" hint="17 SEP 1996"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>성별 / Sex</label>
          <TextField id="info" v-model="Sex" hint="M / F"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>발급일 / Date of issue</label>
          <TextField id="info" v-model="Idate" hint="21 APR 2020"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>만료일 / Date of expiry</label>
          <TextField id="info" v-model="Edate" hint="30 DEC 2025"></TextField>
        </FlexboxLayout>
        <FlexboxLayout>
          <label>주민등록번호 / Personal No.</label>
          <TextField id="info" v-model="PersonalNo" hint="1234567"></TextField>
        </FlexboxLayout>

        <Button id="submit" text="확인" @tap="submit"></Button>
      </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>
<script>
export default {
  data() {
    return {
      Passport: {
        Type: "",
        PassportNo: "",
        Surname: "",
        GivenNames: "",
        Nationality: "",
        Bdate: "",
        Sex: "",
        Idate: "",
        Edate: "",
        PersonalNo: ""
      }
    };
  },
  methods: {
    submit: function() {
      confirm("제출하시겠습니까?").then(res => {
        if (res == true) {
          console.log("true pressed");
        } else {
          console.log("false pressed");
        }
      });
    }
  }
};
</script>
<style scoped>
.background {
  width: 100%;
  height: 70%;
  background: white;
}
label {
  width: 150;
  height: 30;
  size: 10;
}
#info {
  width: 150;
  height: 30;
  color: darkgray;
}
</style>