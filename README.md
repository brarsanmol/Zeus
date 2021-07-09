# Zeus
> ![](https://img.shields.io/static/v1?label=Built%20With&message=Java&style=for-the-badge&logo=java&color=orange) ![](https://img.shields.io/static/v1?label=Built%20With&message=Spigot&style=for-the-badge&logo=minecraft&color=orange)

A lightweight library to ease the creation of scoreboards in the video game Minecraft.

## Installing
> Enter the following in your terminal.
```shell
git clone https://github.com/brarsanmol/Zeus.git
cd Zeus
mvn clean install
```
> Insert the following snippet into your pom.xml.
```xml
<dependency>
    <groupId>ca.anmolbrar</groupId>
    <artifactId>Zeus</artifactId>
    <version>1.0</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```

## Usage
> Zeus makes use of the Adapter pattern to implement the scoreboard. The code sample below is an basic implementation to show you how to get up and running with the library.
```java
public class ExamplePlugin extends JavaPlugin {

    private Zeus zeus;

    @Override
    public void onEnable() {
        [...]
        this.zeus = new Zeus(this, new SidebarAdapterImpl());
    }

    @Override
    public void onDisable() {
        [...]
        this.zeus = null;
    }

}
```

```java
public class SidebarAdapterImpl implements SidebarAdapter {

    @Override
    public String getTitle() {
        return "Example";
    }

    @Override
    public List<String> getLines(Player player) {
        var lines = new ArrayList<String>();

        lines.add("Line 1");
        lines.add("Line 2");
        lines.add("Line 3");
        lines.add("Line 4");

        return lines;
    }
}
```

## Requirements
* Java 14
* Spigot
* Lombok

## Contributors
* [Anmol Brar](https://www.github.com/brarsanmol)