<template>
  <Page>
    <FlexboxLayout width="*" height="*" backgroundColor="White">
      <FlexboxLayout flexDirection="column">
        <FlexboxLayout flexDirection="column">
          <TextField id="sendEmail" hint="이메일 주소 입력" v-model="address"></TextField>
          <Button text="보내기" @tap="send"></Button>
        </FlexboxLayout>
        <FlexboxLayout flexDirection="column">
          <TextField id="confirmMail" hint="인증 번호"></TextField>
          <Button text="인증 확인" @tap="$goto('main',navOptions)"></Button>
        </FlexboxLayout>
      </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>

<script>
import Mail from "@/mail/index.js";

export default {
  data() {
    return {
      address : "",
      pinCode : 1234, //random화 해야함
    };
  },
  methods: {
    send() {
      console.log(this.address);
      Mail.sendEmail(this.address, this.pinCode);
    }
  },
  computed: {
    navOptions() {
      return {
        clearHistory: true,
        backstackVisible: true,
        transition: {
          name: "fade",
          duration: 380,
          curve: "easeIn"
        }
      };
    }
  }
};
</script>

<style>
FlexboxLayout {
  justify-content: center;
  align-items: center;
}
TextField {
  text-align: center;
  width:200;
  height: 40;
  size: 15;
}
#sendMail {
  font-size: 15;
  width: 100;
}
#confirmMail {
  align-self: center;
  font-size: 15;
  width: 100;
}
#title {
  font-size: 30;
}
#pin {
  font-size: 20;
}
</style>