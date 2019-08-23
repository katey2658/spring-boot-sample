import { Component } from 'react';
import { Layout, Menu, Icon } from 'antd';
import Link from 'umi/link';
import { Avatar, Badge } from 'antd';


// Header, Footer, Sider, Content组件在Layout组件模块下
const { Header, Footer, Sider, Content } = Layout;

// 引入子菜单组件
const SubMenu = Menu.SubMenu;


class BasicLayout extends Component {
  render() {
    return (
      <Layout>
        <Sider width={256} style={{ minHeight: '100vh' }}>
          <div style={{ height: '32px', background: 'rgba(255,255,255,.2)', margin: '16px'}}/>
            <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                <Menu.Item key="1">
                    <Link to="/helloworld">
                        <Icon type="pie-chart" />
                        <span>👏欢迎</span>
                    </Link>
                </Menu.Item>
                <SubMenu
                  key="sub1"
                  title={<span><Icon type="dashboard" /><span>控制面板</span></span>}>
                   <Menu.Item key="2"><Link to="/dashboard/analysis">分析页</Link></Menu.Item>
                   <Menu.Item key="3"><Link to="/dashboard/monitor">监控页</Link></Menu.Item>
                   <Menu.Item key="4"><Link to="/dashboard/workplace">工作台</Link></Menu.Item>
                </SubMenu>

                <SubMenu
                  key="sub2"
                  title={<span><Icon type="dashboard" /><span> 数据展示</span></span>}>
                  <Menu.Item key="5"><Link to="/datalist/list">列表项</Link></Menu.Item>
                  <Menu.Item key="6"><Link to="/datalist/puzzlecards">请求项</Link></Menu.Item>
                </SubMenu>
             </Menu>
        </Sider>
        <Layout>
          <Header style={{ background: '#fff', textAlign: 'center', padding: 0 }}>
          <div style={{ float: 'right', marginRight: 30}}>
                <Avatar  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
          <span> katey2658</span>
          </div>
          </Header>
          <Content  style={{ margin: '24px 16px 0' }}>
              <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
              { this.props.children }
              </div>
          </Content>
          <Footer style={{ textAlign: 'center' }}>Busyzero 科技</Footer>
        </Layout>
      </Layout>
    )
  }
}

export default BasicLayout;