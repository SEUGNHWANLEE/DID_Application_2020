<template>
  <Page>
    <FlexboxLayout width="*" height="*" backgroundColor="White">
      <FlexboxLayout flexDirection="column">
          <FlexboxLayout flexDirection="column">
             <Button text="보내기" @tap="$goto('main',navOptions)"></Button>
             <TextField id="sendEmail" hint="이메일 주소 입력" width="*" height="50" ></TextField>
          </FlexboxLayout>
        <FlexboxLayout flexDirection="column">
          <Button text="인증 확인" @tap="$goto('main',navOptions)"></Button>
          <TextField id="confirmMail" hint="인증 번호" width="*" height="50" ></TextField>
        </FlexboxLayout>
      </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>

<script>
export default {
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

<style scoped>
    FlexboxLayout {
        justify-content: center;
        align-items: center;
    }
    #sendMail {
        font-size:30;
    }
    #confirmMail {
        font-size:30;
    }
    #title {
        font-size:30;
    }
    #pin {
        font-size:20;
    }
</style>