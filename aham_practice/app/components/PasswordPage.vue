<template>
  <Page>
    <StackLayout width="*" height="*" backgroundColor="White">
      <StackLayout>
        <TextField hint="password" width="*" height="50" ></TextField>
        <Label text="핀 번호 입력" fontWeight="Bold"></Label>
        <FlexboxLayout flexDirection="row">
          <Button text="뒤로가기" @tap="$goto('password',navOptions)"></Button>
          <Button text="6자리 입력" @tap="$goto('identify',navOptions)"></Button>
        </FlexboxLayout>
      </StackLayout>
    </StackLayout>
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
StackLayout {
    align-items:center;
}
</style>