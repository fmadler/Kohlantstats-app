export function getIconProperties (iconClass) {
  let arr = iconClass.split(" ");
  return { prefix : arr[0], key: arr [1].replace("fa-","")}
}
