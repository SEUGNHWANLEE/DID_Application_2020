<template>
  <Page>
    <StackLayout>
      <TabView :selectedIndex="selectedIndex" iosIconRenderingMode="alwaysOriginal">
        <TabViewItem title="Personal ID">
          <Button text="Personal ID 이용" @tap="service" />
        </TabViewItem>
        <TabViewItem title="여권정보">
          <Button text="여권 이용" @tap="service" />
        </TabViewItem>

        <TabViewItem title="학생증">
          <Button text="학생증 이용" @tap="service" />
        </TabViewItem>
      </TabView>
    </StackLayout>
  </Page>
</template>

<script>
export default {
    data : {

    },
    methods : {
        service() {

        },
        
    }
    
};
</script>

<style scoped>
</style>