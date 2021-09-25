import { NativeModules } from 'react-native';

type KeyboardType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Keyboard } = NativeModules;

export default Keyboard as KeyboardType;
