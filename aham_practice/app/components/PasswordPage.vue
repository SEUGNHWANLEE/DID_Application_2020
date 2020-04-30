<template>
  <Page>
    <ActionBar title="AHAM">
    </ActionBar>
    <FlexboxLayout width="*" height="*" backgroundColor="White">
      <FlexboxLayout flexDirection="column">
          <FlexboxLayout flexDirection="column">
          <Label text="핀 번호 입력" fontWeight="Bold" id="title"></Label>
        <TextField id="pin" hint="password" width="*" height="50" ></TextField>
          </FlexboxLayout>
        <FlexboxLayout flexDirection="row">
          <Button text="뒤로가기" @tap="$goto('main',navOptions)"></Button>
          <Button text="6자리 입력" @tap="$goto('identify',navOptions)"></Button>
        </FlexboxLayout>
      </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>

<script>
// import PasswordPages from "./PasswordPages";
// import IdentificationPage from "./IdentificationPage";
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
  //   methods: {
  //     onBackButton() {
  //       this.$navigateBack();
  //     },
  //     getPassword() {
  //       this.$navigateTo(IdentificationPage);
  //       //this.$navigateTo(PasswordPages);
  //     }
  //   }
};
</script>

<style scoped>
    FlexboxLayout {
        justify-content: center;
        align-items: center;
    }
    #title {
        font-size:30;
    }
    #pin {
        font-size:20;
    }
</style>