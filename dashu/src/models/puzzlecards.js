import request from '../util/request';
import { message } from 'antd';

const delay = (millisecond) => {
  return new Promise((resolve) => {
    setTimeout(resolve, millisecond);
  });
};

export default {
  namespace: 'puzzlecards',
  state: {
    data: [],
    counter: 0,
  },
  effects: {
    *queryInitCards(_, sagaEffects) {
      const { call, put } = sagaEffects;
      const endPointURI = 'http://localhost:8080/data';

      // const puzzle = yield call(request, endPointURI);
      // yield put({ type: 'addNewCard', payload: puzzle });

      yield call(delay, 1000);

      try{
        message.success("请求成功");
        const puzzle2 = yield call(request, endPointURI);
        yield put({ type: 'addNewCard', payload: puzzle2 });
      }catch (e) {
         message.error(e);
      }
    }
  },
  reducers: {
    addNewCard(state, { payload: newCard }) {
      const nextCounter = state.counter + 1;
      const newCardWithId = { ...newCard, id: nextCounter };
      console.log(newCardWithId);
      const nextData = state.data.concat(newCardWithId);
      return {
        data: nextData,
        counter: nextCounter,
      };
    },
    delCard(state) {
      const nextCounter = state.counter - 1;
      const nextData = state.data.slice(1);
      console.log(nextData);
      return {
        data: nextData,
      };
    }
  },
};