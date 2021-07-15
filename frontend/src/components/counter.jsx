import React, { Component } from "react";

class Counter extends Component {
  // Object that includes any data that the component needs
  state = {
    count: 0,
    tags: ["tag1", "tag2", "tag3"],
    // tags: [],
  };
  // Define the property here and reference it later
  styles = {
    fontSize: 10,
    fontWeight: "bold",
  };

  render() {
    // Use let for variables and const for constants
    return (
      // If use div the it might result in multiple divs, so use React.Fragment
      // Pass in argument via () => this.<function name>(argument)
      <React.Fragment>
        {/* Use curly braces if you want to render dynamically */}
        <span className={this.getBadegClasses()}>{this.formatCount()}</span>
        <button
          onClick={() => this.increment(1)}
          className="btn btn-secondary btn-sm"
        >
          Increment
        </button>
        <button onClick={this.decrement} className="btn btn-secondary btn-sm">
          Decrement
        </button>
        {/* In JSX expressions we don't have the concept of loops */}
        <ul>
          {/* In real application, the tag may be object so the key can be the object ID */}
          {this.state.tags.map((tag) => (
            <li key={tag}>{tag}</li>
          ))}
        </ul>
      </React.Fragment>
    );
  }

  // render() {
  //   return (
  //     // Use the && sign to display the content after the sign if pervious condition is true
  //     // If the operhend is true, e.g.  'Hi' or any number other than 0, it will continue along the && train
  //     <div>
  //       {this.state.tags.length === 0 && "Please create a new tag!"}
  //       {this.renderTags()}
  //     </div>
  //   );
  // }

  // renderTags() {
  //   if (this.state.tags.length === 0) return <p>There are no tags!</p>;

  //   return (
  //     <ul>
  //       {this.state.tags.map((tag) => (
  //         <li key={tag}>{tag}</li>
  //       ))}
  //     </ul>
  //   );
  // }

  // Need to fillout the bracket to contain the argument
  increment = (product) => {
    this.setState({ count: this.state.count + product });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  getBadegClasses() {
    let classes = "badge m-2 bg-";
    classes += this.state.count === 0 ? "warning" : "primary";
    return classes;
  }

  formatCount() {
    const { count } = this.state;
    return count === 0 ? "Zero" : count;
  }
}
export default Counter;
