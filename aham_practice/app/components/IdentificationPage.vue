<template>
  <Page>
      <ActionBar title="Service" height="30" backgroundColor="#6EC8FF">
        <NavigationButton
          text="Go back"
          android.systemIcon="ic_menu_back"
          @tap="$goto('main',navOptions)"
        />
      </ActionBar>
    <StackLayout>
      <TabView :selectedIndex="selectedIndex" iosIconRenderingMode="alwaysOriginal">
        <TabViewItem title="Personal ID" iconSource="~/images/icon.png">
          <Button text="ID : 개인정보 입력" />
        </TabViewItem>

        <TabViewItem title="여권정보" iconSource="~/images/icon.png">
          <Button text="여권 : 개인정보 입력" />
        </TabViewItem>

        <TabViewItem title="학생증" iconSource="~/images/icon.png">
          <Button text="학생증 : 개인정보 입력" />
        </TabViewItem>
      </TabView>
    </StackLayout>
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

<style>
</style>