import React from 'react';
import { connect } from 'dva';
import SampleChart from "../../components/SampleChart";

function mapStateToProps(state) {
    return {
        cardsList: state.cards.cardsList,
        cardsLoading: state.loading.effects['cards/queryList'],
    };
}


@connect(mapStateToProps)
class Chart extends React.Component{
    showStatistic = (id) => {
        this.props.dispatch({
            type: 'cards/getStatistic',
            payload: id,
        });
        // 更新 state，弹出包含图表的对话框
        this.setState({ id, statisticVisible: true });
    };

    handleStatisticCancel = () => {
        this.setState({
            statisticVisible: false,
        });
    }
    componentWillUnmount() {
        if (this.chart) {
            this.chart.destroy();
        }
    }

    columns = [
        // ...
        {
            title: '',
            dataIndex: '_',
            render: (_, { id }) => {
                return (
                    <Button onClick={() => { this.showStatistic(id); }}>图表</Button>
            );
            },
        },
    ];
    render() {
        const { /* ... */ statisticVisible, id } = this.state;
        const { /* ... */ statistic } = this.props;

        return (
            <div>
            {/* ... */}

            <Modal visible={statisticVisible} footer={null} onCancel={this.handleStatisticCancel}>
            <SampleChart data={statistic[id]} />
        </Modal>
        </div>
    );
    }
}

export default connect(mapStateToProps)(Chart);
