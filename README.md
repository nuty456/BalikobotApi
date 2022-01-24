# Balikobot API


[![Build Status][ico-workflow]][link-workflow]
[![Software License][ico-license]][link-licence]

Offers implementation of Balikobot API v2 described in the [documentation](#version)

## Usage example

See more available methods documentation in [Usage](#usage) section.

> *All the code snippets shown here are modified for clarity, so they may not be executable.*


#### Setup service

```java
// credentials
final String apiUser = "USER";
final String apiKey  = "API_KEY";

// init balikobot class
Requester requester = new Requester(apiUser, apiKey, true, vertX);
Balikobot balikobot = new Balikobot(requester);
```


#### Create packages and order shipment

```java
// create new package collection for specific shipper
PackageCollection packages = new PackageCollection(Shipper.CP);

// create new package
BalikobotPackage p = new BalikobotPackage();
p.setEID("UNI_EID");
p.setBranchId(INT_BRANCH_ID);
p.setServiceType(ServiceType.CP_DR);
p.setRecName("Karel Loprais");
p.setRecStreet("Ulice");
p.setRecCity("Mesto");
p.setRecZip("PSC");
p.setRecCountry(CountryEnum.CZECH_REPUBLIC);
p.setRecPhone("TELEFON");
p.setRecEmail("EMAIL");
p.setPrice(666.0);
p.setInsCurrency(Currency.CZK);
p.setVS("VS");
p.setReturnTrack(true);


// add package to collection
packages.add(p);

// upload packages to balikobot
OrderedPackageCollection orderedPackages = balikobot.addPackages(packages);

// package information
for (OrderedPackage orderedPackage : orderedPackages.getPackages()) {
    log.info("Processing " + orderedPackage);

    log.debug(orderedPackage.getPackageId());
    log.debug(orderedPackage.getBatchId());
    log.debug(orderedPackage.getCarrierId());
    log.debug(orderedPackage.getTrackUrl());
    log.debug(orderedPackage.getLabelUrl());
}

// order shipment for packages
OrderedShipment orderedShipment = balikobot.orderShipment(orderedPackageCollection);

// save order ID and labels URL
if (orderedShipment != null){
    log.debug(orderedShipment.getOrderId());
    log.debug(orderedShipment.getFileUrl());
    log.debug(orderedShipment.getLabelsUrl());
    log.debug(orderedShipment.getHandoverUrl());
}

```


#### Test packages data / delete packages

```java
Requester requester = new Requester(apiUser, apiKey, true, vertX);
Balikobot balikobot = new Balikobot(requester);

OrderedPackage orderedPackage = new OrderedPackage(PACKAGE_ID_FROM_ORDERED_PACKAGE, Shipper.CP, BATCH_ID_FROM_ORDERED_PACKAGE, CARRIER_ID_FROM_ORDERED_PACKAGE);

// drop packages if shipment is not ordered yet
final List<PackageDropStatus> packageDropStatuses = balikobot.dropPackages(orderedPackage);
````


#### Track packages

```java
Requester requester = new Requester(apiUser, apiKey, true, vertX);
Balikobot balikobot = new Balikobot(requester);

OrderedPackage orderedPackage = new OrderedPackage(PACKAGE_ID_FROM_ORDERED_PACKAGE, Shipper.CP, BATCH_ID_FROM_ORDERED_PACKAGE, CARRIER_ID_FROM_ORDERED_PACKAGE);

// track last package status
final PackageStatus packageStatus = balikobot.trackPackage(orderedPackage);
if (packageStatus != null){
    log.info(String.format("Getting status for package: %s / with result: %s",balikobotOrderDomain,packageStatus));
}
```

#### Import branches

```java
// get only branches for Zasilkovna in CZ/SK
Requester requester = new Requester(apiUser, apiKey, true, vertX);
Balikobot balikobot = new Balikobot(requester);

final ArrayList<Branch> branchList = balikobot.getBranchesForShipperForCountries(Shipper.ZASILKOVNA, Arrays.asList(CountryEnum.CZECH_REPUBLIC, CountryEnum.SLOVAKIA));
for (Branch branch : branchList) {
    log.info("Branch: " + branch);
}
```


## System requirements

* [Java 8](https://www.java.com/download/java8_update.jsp)
* [Vert.x](https://vertx.io/)
* [Maven](https://maven.apache.org/)

## Installation

Run:
```
mvn clean install
```

## Version

Support all options for Balikobot API [v2][link-api-v2-upgrade] described in the official [documentation][link-api-v2] until **v1.944** *(2021-12-07)*.


## Contributing

Please see [CONTRIBUTING][link-contributing] and [CODE_OF_CONDUCT][link-code-of-conduct] for details.


## Security

If you discover any security related issues, please email jirka.bendl@gmail.com instead of using the issue tracker.


## Credits

- [Jiří Bendl](https://github.com/nuty456)
- [All Contributors][link-contributors]


## License

The MIT License (MIT). Please see [License File][link-licence] for more information.


[ico-license]:              https://img.shields.io/github/license/inspirum/balikobot-php.svg?style=flat-square&colorB=blue
[ico-workflow]:             https://img.shields.io/github/workflow/status/inspirum/balikobot-php/Test/master?style=flat-square
[ico-scrutinizer]:          https://img.shields.io/scrutinizer/coverage/g/inspirum/balikobot-php/master.svg?style=flat-square
[ico-code-quality]:         https://img.shields.io/scrutinizer/g/inspirum/balikobot-php.svg?style=flat-square
[ico-packagist-stable]:     https://img.shields.io/packagist/v/inspirum/balikobot.svg?style=flat-square&colorB=blue
[ico-packagist-download]:   https://img.shields.io/packagist/dt/inspirum/balikobot.svg?style=flat-square&colorB=blue
[ico-phpstan]:              https://img.shields.io/badge/style-level%208-brightgreen.svg?style=flat-square&label=phpstan

[link-author]:              https://github.com/inspirum
[link-contributors]:        https://github.com/inspirum/balikobot-php/contributors
[link-licence]:             ./LICENSE.md
[link-changelog]:           ./CHANGELOG.md
[link-contributing]:        ./docs/CONTRIBUTING.md
[link-code-of-conduct]:     ./docs/CODE_OF_CONDUCT.md
[link-workflow]:            https://github.com/inspirum/balikobot-php/actions
[link-scrutinizer]:         https://scrutinizer-ci.com/g/inspirum/balikobot-php/code-structure
[link-code-quality]:        https://scrutinizer-ci.com/g/inspirum/balikobot-php
[link-api]:                 https://balikobot.docs.apiary.io/#introduction/prehled-zmen
[link-api-v2]:              https://balikobotv2.docs.apiary.io/#introduction/prehled-zmen
[link-api-v2-upgrade]:      https://balikobotv2.docs.apiary.io/#introduction/rozdil-api-v2-vs-api-v1
[link-inspishop]:           https://www.inspishop.cz/
[link-inspirum]:            https://www.inspirum.cz/
[link-packagist-stable]:    https://packagist.org/packages/inspirum/balikobot
[link-packagist-download]:  https://packagist.org/packages/inspirum/balikobot
[link-phpstan]:             https://github.com/phpstan/phpstan