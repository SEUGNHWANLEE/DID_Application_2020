<template>
  <Page>
    <StackLayout>
      <ActionBar title="핀 비밀번호 설정" />
      <StackLayout>
        <Label text="Logo is here ! " />
        <TextField secure="false" hint="password" />
        <Label text="핀 번호 입력" fontWeight="Bold" />
        <FlexboxLayout flexDirection="row">
          <Button text="뒤로가기" @tap="$goto('password',navOptions)" />
          <Button text="6자리 입력" @tap="$goto('identify',navOptions)" />
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

<style>
</style>