export default {
  plugins: [
    ['umi-plugin-react', {
      antd: true,
      dva: true,
    }],
  ],
  proxy: {
        '/dev': {
          target: 'https://localhost:8080/data',
          changeOrigin: true,
      },
  },
  routes:[
    {
      path:'/',
      component: '../layout',
      routes: [
        {
          path: '/',
          component: 'Helloworld',
        },
        {
          path: '/helloworld',
          component: 'Helloworld'
        },
        {
          path: '/dashboard',
          routes: [
            { path: '/dashboard/analysis', component: 'Dashboard/Analysis' },
            { path: '/dashboard/monitor', component: 'Dashboard/Monitor' },
            { path: '/dashboard/workplace', component: 'Dashboard/Workplace' }
          ]
        },

        {
          path: '/datalist',
          routes: [
            { path: '/datalist/list', component: 'DataList/index' },
            { path: '/datalist/puzzlecards', component: 'DataList/puzzlecards' },
          ]
        }
      ]
    },
  ]
}
