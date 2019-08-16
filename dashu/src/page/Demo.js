class Demo extends React.Component {
    state = {
        text: '',
      }
    
      onTextChange = (event) => {
        this.setState({ text: event.target.value });
      }
    
  
    render() {
      return (
<MyInput value={this.state.text} onChange={this.onTextChange} />      );
    }
  }